package com.example.market_service.controllers;

import com.example.market_service.domain.DTOs.OrdersDTO;
import com.example.market_service.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }


    @PostMapping("/orders")
    public ResponseEntity<OrdersDTO> placeOrder(@RequestBody OrdersDTO ordersDTO){
       OrdersDTO placedOrder =  ordersService.placeOrder(ordersDTO);
       return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{orderid}")
    public void cancelOrder(@PathVariable("orderid") Long orderid){
        ordersService.cancelOrder(orderid);
    }

    @GetMapping("/orders/{orderid}")
    public ResponseEntity<OrdersDTO> getOrder(@PathVariable("orderid") Long orderid){
        return new ResponseEntity<>(ordersService.getOrder(orderid), HttpStatus.FOUND);
    }

    @GetMapping("/orders/artist/{artistid}")
    public ResponseEntity<List<OrdersDTO>> getArtistOrders(@PathVariable("artistid") Long artistID){
        return new ResponseEntity<>(ordersService.getArtistOrders(artistID), HttpStatus.FOUND);
    }

    @GetMapping("orders/client/{clientid}")
    public ResponseEntity<List<OrdersDTO>> getClientOrders(@PathVariable("clientid") Long clientID){
        return new ResponseEntity<>(ordersService.getClientOrders(clientID), HttpStatus.FOUND);
    }

}
