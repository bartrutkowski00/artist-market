package com.example.market_service.domain.DTOs;

import java.time.LocalDate;

public class OrdersDTO {

    private Long ordersid;
    private String name;
    private Long paymentid;
    private Long clientid;
    private Long artistid;
    private LocalDate eventdate;
    private EventTypeDTO eventtype;
    private LocalDate createddate;

    public OrdersDTO() {
    }

    public OrdersDTO(Long ordersid, String name, Long paymentid, Long clientid, Long artistid, LocalDate eventdate, EventTypeDTO eventtype, LocalDate createddate) {
        this.ordersid = ordersid;
        this.name = name;
        this.paymentid = paymentid;
        this.clientid = clientid;
        this.artistid = artistid;
        this.eventdate = eventdate;
        this.eventtype = eventtype;
        this.createddate = createddate;
    }

    public Long getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Long ordersid) {
        this.ordersid = ordersid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Long paymentid) {
        this.paymentid = paymentid;
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public Long getArtistid() {
        return artistid;
    }

    public void setArtistid(Long artistid) {
        this.artistid = artistid;
    }

    public LocalDate getEventdate() {
        return eventdate;
    }

    public void setEventdate(LocalDate eventdate) {
        this.eventdate = eventdate;
    }

    public EventTypeDTO getEventtype() {
        return eventtype;
    }

    public void setEventtype(EventTypeDTO eventtype) {
        this.eventtype = eventtype;
    }

    public LocalDate getCreateddate() {
        return createddate;
    }

    public void setCreateddate(LocalDate createddate) {
        this.createddate = createddate;
    }
}
