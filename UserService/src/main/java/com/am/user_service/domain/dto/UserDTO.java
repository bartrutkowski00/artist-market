package com.am.user_service.domain.dto;

import com.am.user_service.domain.entities.CityEntity;
import com.am.user_service.domain.entities.UserroleEntity;
import com.am.user_service.domain.entities.UsrEntity;
import com.am.user_service.security.Encryption;


import java.util.Date;

public class UserDTO {

    private Long userid;
    private String username;
    private String password;
    private String email;
    private Integer phone;
    private CityEntity city;
    private UserroleEntity userrole;
    private Boolean activatedind;
    private Date createddate;
    private Date updateddate;

    public UserDTO(String username, String password, Long userid, String email, Integer phone, CityEntity city, Date createddate, Date updateddate, UserroleEntity userrole, Boolean activatedind) {
        this.username = username;
        this.password = password;
        this.userid = userid;
        this.activatedind = activatedind;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.createddate = createddate;
        this.updateddate = updateddate;
        this.userrole = userrole;
    }

    public UserDTO(UsrEntity usrEntity) {
        this.username = usrEntity.getUsername();
        this.password = usrEntity.getPassword() == null ? null : Encryption.decrypt(usrEntity.getPassword());
        this.userid = usrEntity.getUsrid();
        this.email = usrEntity.getEmail();
        this.phone = usrEntity.getPhone();
        this.city = usrEntity.getCity();
        this.createddate = usrEntity.getCreateddate();
        this.updateddate = usrEntity.getUpdateddate();
        this.userrole = usrEntity.getUserrole();
        this.activatedind = usrEntity.getActivatedind();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivatedind() {
        return activatedind;
    }

    public void setActivatedind(Boolean activatedind) {
        this.activatedind = activatedind;
    }

    public UserDTO(){

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public UserroleEntity getUserrole() {
        return userrole;
    }

    public void setUserrole(UserroleEntity userrole) {
        this.userrole = userrole;
    }
}
