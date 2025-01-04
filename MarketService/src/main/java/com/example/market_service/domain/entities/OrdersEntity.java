package com.example.market_service.domain.entities;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    @Column(name = "ordersid")
    private Long ordersid;
    private String name;
    private Long paymentid;
    private Long clientid;
    private Long artistid;
    private LocalDate eventdate;
    @ManyToOne
    @JoinColumn(name = "eventtypeid")
    private EventTypeEntity eventtype;
    @CreatedDate
    private LocalDate createddate;

    public OrdersEntity() {
    }

    public OrdersEntity(Long ordersid, String name, Long paymentid, Long clientid, LocalDate eventdate, LocalDate createddate, EventTypeEntity eventtype, Long artistid) {
        this.ordersid = ordersid;
        this.name = name;
        this.paymentid = paymentid;
        this.clientid = clientid;
        this.eventdate = eventdate;
        this.createddate = createddate;
        this.eventtype = eventtype;
        this.artistid = artistid;
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

    public EventTypeEntity getEventtype() {
        return eventtype;
    }

    public void setEventtype(EventTypeEntity eventtype) {
        this.eventtype = eventtype;
    }

    public LocalDate getCreateddate() {
        return createddate;
    }

    public void setCreateddate(LocalDate createddate) {
        this.createddate = createddate;
    }
}
