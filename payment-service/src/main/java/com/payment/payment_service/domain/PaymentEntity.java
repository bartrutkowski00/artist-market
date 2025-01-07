package com.payment.payment_service.domain;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "payment")
@EntityListeners(AuditingEntityListener.class)
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", allocationSize = 1)
    @Column(name = "paymentid")
    private Long paymentid;
    private Long orderid;
    private Long clientid;
    private Boolean paid;

    public PaymentEntity(Long paymentid, Long orderid, Long clientid, Boolean paid) {
        this.paymentid = paymentid;
        this.orderid = orderid;
        this.paid = paid;
        this.clientid = clientid;
    }

    public PaymentEntity() {
    }

    public Long getPaymentid() {
        return paymentid;
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public void setPaymentid(Long paymentid) {
        this.paymentid = paymentid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
