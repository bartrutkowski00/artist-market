package com.example.market_service.services;


import com.example.market_service.domain.DTOs.OrdersDTO;
import com.example.market_service.utils.TestUtils;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    public void testThatOrderIsAdded(){
        OrdersDTO recievedDTO = TestUtils.createOrderDTO();
        underTest.placeOrder(recievedDTO);
    }

}
