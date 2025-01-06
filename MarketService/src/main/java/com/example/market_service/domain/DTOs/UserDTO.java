package com.example.market_service.domain.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class UserDTO {

    private Long userid;
    private String username;

    @JsonProperty("userrole")
    private void unpackNameFromNestedObject(Map<String, String> userrole) {
        userroleId = Long.parseLong(userrole.get("userroleid"));
    }

    private Long userroleId;
    private Boolean activatedind;

    public UserDTO(){}



    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserroleId() {
        return userroleId;
    }

    public void setUserroleId(Long userroleId) {
        this.userroleId = userroleId;
    }

    public Boolean getActivatedind() {
        return activatedind;
    }

    public void setActivatedind(Boolean activatedind) {
        this.activatedind = activatedind;
    }
}
