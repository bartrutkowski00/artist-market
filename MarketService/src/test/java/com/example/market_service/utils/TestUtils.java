package com.example.market_service.utils;

import com.example.market_service.domain.DTOs.EventTypeDTO;
import com.example.market_service.domain.DTOs.OrdersDTO;


import java.time.LocalDate;


public class TestUtils {

    public static OrdersDTO createOrderDTO(){
        return new OrdersDTO(
                null,
                "TestOrder",
                1L,
                1L,
                10000L,
                LocalDate.now(),
                new EventTypeDTO(1L, null),
                null
        );
    }


}
