package domain.entities;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "usr")

public class UsrEntity {

    @Id
    private Long usrid;
    private String username;
    private String email;
    private Integer phone;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cityid")
    private CityEntity city;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userroleid")
    private UserroleEntity userrole;
    private Date createddate;
    private Date updateddate;

    public UsrEntity(){

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

    public UsrEntity(Long usrid, String username, String email, Integer phone, CityEntity city, UserroleEntity userrole, Date updateddate, Date createddate) {
        this.usrid = usrid;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.userrole = userrole;
        this.updateddate = updateddate;
        this.createddate = createddate;
    }
}
