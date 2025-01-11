package com.payment.payment_service.services;

import com.payment.payment_service.domain.PaymentDTO;
import com.payment.payment_service.domain.PaymentEntity;
import com.payment.payment_service.repositories.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "place.payment.order", groupId = "payment-service-group")
    public void addPaymentOrder(String message){
        String[] paymentData = message.split(",");

        PaymentEntity paymentEntity = new PaymentEntity(null, Long.parseLong(paymentData[0]), Long.parseLong(paymentData[1]), false);
        paymentRepository.save(paymentEntity);
    }

    public List<PaymentDTO> getClientUnpaidPayments(Long clientId){

        return paymentRepository.findAllByClientid(clientId).stream()
                .map(val->{
                    return modelMapper.map(val, PaymentDTO.class);
                })
                .filter(val -> val.getPaid() == false)
                .collect(Collectors.toList());

    }

    public PaymentDTO fulfillPayment(Long paymentid){
        PaymentEntity paymentToBePaid = paymentRepository.findById(paymentid).orElseThrow(() -> new RuntimeException("No payment with this ID exists"));
        fulfillPaymentValidation(paymentToBePaid);
        paymentToBePaid.setPaid(true);
        paymentRepository.save(paymentToBePaid);

        kafkaTemplate.send("fulfill.payment.order", paymentToBePaid.getPaymentid() + "," + paymentToBePaid.getOrderid());
        return modelMapper.map(paymentToBePaid, PaymentDTO.class);

    }

    private void fulfillPaymentValidation(PaymentEntity payment){
        if(payment.getPaid()){
            throw new IllegalArgumentException("Order have already been paid");
        }
    }

}
