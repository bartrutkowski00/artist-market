package com.example.market_service.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventtype")
public class EventTypeEntity {

    @Id
    private Long eventtypeid;
    private String name;

    public EventTypeEntity() {
    }

    public EventTypeEntity(Long eventtypeid, String name) {
        this.eventtypeid = eventtypeid;
        this.name = name;
    }

    public Long getEventtypeid() {
        return eventtypeid;
    }

    public void setEventtypeid(Long eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
