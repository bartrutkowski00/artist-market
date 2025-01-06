package com.example.market_service.services;


import com.example.market_service.domain.DTOs.OrdersDTO;
import com.example.market_service.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

//@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext
public class OrdersServiceIntegrationTests {

    private OrdersService underTest;

    @Autowired
    public OrdersServiceIntegrationTests(OrdersService ordersService){
        this.underTest = ordersService;
    }

    @Test
    public void testProcess(){
        OrdersDTO recievedDTO = TestUtils.createOrderDTO();

        OrdersDTO placedOrder = underTest.placeOrder(recievedDTO);
        System.out.println("Placed order: " + placedOrder.getOrdersid());
        OrdersDTO getOrder = underTest.getOrder(placedOrder.getOrdersid());
        System.out.println("Get order: " + getOrder.getOrdersid());
        List<OrdersDTO> getArtistOrder = underTest.getArtistOrders(placedOrder.getArtistid());
        System.out.println("Artist orders: " + getArtistOrder.size());
        List<OrdersDTO> getClientOrder = underTest.getClientOrders(placedOrder.getClientid());
        System.out.println("Client orders: " + getClientOrder.size());
        underTest.cancelOrder(placedOrder.getOrdersid());
        System.out.println("Order deleted");


    }



}
