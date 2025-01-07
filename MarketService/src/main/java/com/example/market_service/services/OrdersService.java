package com.example.market_service.services;

import com.example.market_service.communication.UserServiceFeign;
import com.example.market_service.domain.DTOs.OrdersDTO;
import com.example.market_service.domain.entities.OrdersEntity;
import com.example.market_service.repositories.OrdersRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    private OrdersRepository ordersRepository;
    private ModelMapper modelMapper;
    private UserServiceFeign userServiceFeign;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Transactional
    @KafkaListener(topics = "delete.user.orders", groupId = "market-service-group")
    public void handleUserOrderDeletion(String message){
        ordersRepository.deleteByClientid(Long.parseLong(message));
        ordersRepository.deleteByArtistid(Long.parseLong(message));
        System.out.println("Deleted all " + message + " user orders.");

    }

    @KafkaListener(topics = "fulfill.payment.order", groupId = "market-service-group")
    public void fulfillPaymentOrder(String message){
        String[] paymentData = message.split(",");
        OrdersEntity paidOrder = ordersRepository.findById(Long.parseLong(paymentData[1])).orElseThrow(() -> new RuntimeException("Order not found, payment could not be made."));

        paidOrder.setPaymentid(Long.parseLong(paymentData[0]));
        ordersRepository.save(paidOrder);

    }

    OrdersService(OrdersRepository ordersRepository, ModelMapper modelMapper, UserServiceFeign userServiceFeign, KafkaTemplate<String, String> kafkaTemplate){
        this.ordersRepository = ordersRepository;
        this.modelMapper = modelMapper;
        this.userServiceFeign = userServiceFeign;
        this.kafkaTemplate = kafkaTemplate;
    }

    public OrdersDTO placeOrder(OrdersDTO ordersDTO){

        validateOrder(ordersDTO);
        validateArtist(ordersDTO.getArtistid());
        validateClient(ordersDTO.getClientid());
        validateUserIsActive(ordersDTO.getClientid());
        validateUserIsActive(ordersDTO.getArtistid());

        OrdersEntity ordersEntity = modelMapper.map(ordersDTO, OrdersEntity.class);
        OrdersEntity savedEntity = ordersRepository.save(ordersEntity);

        OrdersDTO savedOrder = modelMapper.map(savedEntity, OrdersDTO.class);
        kafkaTemplate.send("place.payment.order", savedOrder.getOrdersid() + "," + savedOrder.getClientid());

        return savedOrder;
    }

    public void cancelOrder (Long orderId){
        validateOrderExist(orderId);
        ordersRepository.deleteById(orderId);
    }

    public OrdersDTO getOrder(Long orderID){
        validateOrderExist(orderID);

        OrdersEntity ordersEntity = ordersRepository.findById(orderID).get();
        return modelMapper.map(ordersEntity, OrdersDTO.class);
    }

    public List<OrdersDTO> getArtistOrders(Long artistId){
        validateArtist(artistId);
        List<OrdersDTO> ordersList = ordersRepository.findByArtistid(artistId).stream()
                .map((val)->{
                    return modelMapper.map(val, OrdersDTO.class);
                })
                .collect(Collectors.toList());

        return ordersList;

    }

    public List<OrdersDTO> getClientOrders(Long clientId){
        validateClient(clientId);
        List<OrdersDTO> ordersList = ordersRepository.findByClientid(clientId).stream()
                .map((val)->{
                    return modelMapper.map(val, OrdersDTO.class);
                })
                .collect(Collectors.toList());

        return ordersList;

    }

    private void validateOrder(OrdersDTO ordersDTO){
        if(ordersDTO.getOrdersid() != null || ordersDTO.getCreateddate() != null){
            throw new IllegalArgumentException("OrderId and CreatedDate has to be null");
        }

    }

    private void validateOrderExist(Long orderId){
        if(!ordersRepository.existsById(orderId)){
            throw new IllegalArgumentException("Order does not exist");
        }

    }

    private void validateArtist(Long artistId){
        if(userServiceFeign.getUser(artistId).getUserroleId() != 2){
            throw new IllegalArgumentException("Artist don't exist");
        }
    }

    private void validateClient(Long clientID){
        if(userServiceFeign.getUser(clientID).getUserroleId() != 1){
            throw new IllegalArgumentException("Client don't exist");
        }
    }

    private void validateUserIsActive(Long userID){
        if (!userServiceFeign.getUser(userID).getActivatedind()){
            if(userServiceFeign.getUser(userID).getUserroleId() == 2){
                throw new IllegalArgumentException("Artist isn't active");
            }else {
                throw new IllegalArgumentException("Client isn't active");
            }
        }
    }




}
