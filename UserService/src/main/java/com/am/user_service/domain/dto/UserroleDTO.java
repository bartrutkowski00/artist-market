package com.am.user_service.domain.dto;

import com.am.user_service.domain.entities.UserroleEntity;
import jakarta.persistence.Id;

public class UserroleDTO {

    private Long userroleid;
    private String description;

    public UserroleDTO(UserroleEntity userroleEntity){
        this.userroleid = userroleEntity.getUserroleid();
        this.description = userroleEntity.getDescription();
    }

    public UserroleDTO(Long userroleid, String description) {
        this.userroleid = userroleid;
        this.description = description;
    }

    public UserroleDTO(){

    }

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
