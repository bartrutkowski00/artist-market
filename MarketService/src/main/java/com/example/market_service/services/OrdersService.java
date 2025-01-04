package com.example.market_service.services;

import com.example.market_service.domain.DTOs.OrdersDTO;
import com.example.market_service.domain.entities.OrdersEntity;
import com.example.market_service.repositories.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private OrdersRepository ordersRepository;
    private ModelMapper modelMapper;

    OrdersService(OrdersRepository ordersRepository, ModelMapper modelMapper){
        this.ordersRepository = ordersRepository;
        this.modelMapper = modelMapper;
    }

    public OrdersDTO placeOrder(OrdersDTO ordersDTO){
        if(ordersDTO.getOrdersid() != null || ordersDTO.getCreateddate() != null){
            throw new RuntimeException("OrderId and CreatedDate has to be null");
        }
        

        OrdersEntity ordersEntity = modelMapper.map(ordersDTO, OrdersEntity.class);
        OrdersEntity savedEntity = ordersRepository.save(ordersEntity);

        return modelMapper.map(savedEntity, OrdersDTO.class);
    }



}
