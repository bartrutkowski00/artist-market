package com.am.user_service.domain.entities;

import com.am.user_service.domain.dto.UserDTO;
import com.am.user_service.security.Encryption;
import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "usr")

public class UsrEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "usr_seq")
    @SequenceGenerator(name = "usr_seq", sequenceName = "usr_seq", allocationSize = 1)
    @Column(name = "usrid")
    private Long usrid;
    private String username;
    private String password;
    private String email;
    private Integer phone;
    @ManyToOne
    @JoinColumn(name = "cityid")
    private CityEntity city;
    @ManyToOne
    @JoinColumn(name = "userroleid")
    private UserroleEntity userrole;
    private Boolean activatedind;
    private Date createddate;
    private Date updateddate;

    public UsrEntity(){
    }

    public String getPassword() {
        return Encryption.decrypt(password);
    }

    public void setPassword(String password) {
        this.password = Encryption.encrypt(password);
    }

    public Boolean getActivatedind() {
        return activatedind;
    }

    public void setActivatedind(Boolean activatedind) {
        this.activatedind = activatedind;
    }

    public UsrEntity(UserDTO userDTO){
        this.city = userDTO.getCity();
        this.createddate = userDTO.getCreateddate();
        this.updateddate = userDTO.getUpdateddate();
        this.email = userDTO.getEmail();
        this.phone = userDTO.getPhone();
        this.usrid = userDTO.getUserid();
        this.userrole = userDTO.getUserrole();
        this.username = userDTO.getUsername();
        this.password = Encryption.encrypt(userDTO.getPassword());
        this.activatedind = userDTO.getActivatedind();
    }

    public Long getUsrid() {
        return usrid;
    }

    public void setUsrid(Long usrid) {
        this.usrid = usrid;
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

    public UsrEntity(Long usrid, String username, String password, Boolean activatedind, String email, Integer phone, CityEntity city, UserroleEntity userrole, Date updateddate, Date createddate) {
        this.usrid = usrid;
        this.username = username;
        this.password = Encryption.encrypt(password);
        this.email = email;
        this.phone = phone;
        this.activatedind = activatedind;
        this.city = city;
        this.userrole = userrole;
        this.updateddate = updateddate;
        this.createddate = createddate;
    }
}
