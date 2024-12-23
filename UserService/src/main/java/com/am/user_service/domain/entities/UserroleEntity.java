package com.am.user_service.domain.entities;

import com.am.user_service.domain.dto.UserroleDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "userrole")

public class UserroleEntity {
    @Id
    private Long userroleid;
    private String description;

    public UserroleEntity(Long userroleid, String description) {
        this.userroleid = userroleid;
        this.description = description;
    }

    public UserroleEntity() {
    }

    public UserroleEntity(UserroleDTO userroleDTO){
        this.userroleid = userroleDTO.getUserroleid();
        this.description = userroleDTO.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }
}

