package com.example.market_service.domain.DTOs;

public class EventTypeDTO {

    private Long eventtypeid;
    private String name;

    public EventTypeDTO() {
    }

    public EventTypeDTO(Long eventtypeid, String name) {
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
