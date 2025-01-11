package com.payment.payment_service.controllers;

import com.payment.payment_service.domain.PaymentDTO;
import com.payment.payment_service.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PatchMapping("/payment/{paymentid}")
    public ResponseEntity<PaymentDTO> fulfillOrder(@PathVariable("paymentid") Long paymentid) {

        return new ResponseEntity<>(paymentService.fulfillPayment(paymentid), HttpStatus.ACCEPTED);

    }

    @GetMapping("/payment/client/{id}")
    public ResponseEntity<List<PaymentDTO>> getClientUnpaidPayments(@PathVariable("id") Long clientid){
        return new ResponseEntity<>(paymentService.getClientUnpaidPayments(clientid), HttpStatus.OK);
    }
}
