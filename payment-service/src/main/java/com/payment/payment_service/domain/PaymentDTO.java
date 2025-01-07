package com.payment.payment_service.domain;

public class PaymentDTO {
    private Long paymentid;
    private Long orderid;
    private Long clientid;
    private Boolean paid;

    public Long getPaymentid() {
        return paymentid;
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

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public PaymentDTO(Long paymentid, Long orderid, Long clientid, Boolean paid) {
        this.paymentid = paymentid;
        this.orderid = orderid;
        this.paid = paid;
        this.clientid = clientid;
    }

    public PaymentDTO() {
    }
}
