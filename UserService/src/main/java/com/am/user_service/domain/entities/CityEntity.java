package com.am.user_service.domain.entities;
import com.am.user_service.domain.dto.CityDTO;
import jakarta.persistence.*;


@Entity
@Table(name = "city")
public class CityEntity {
    @Id
    private Long cityid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countryid")
    private CountryEntity country;
    private String name;

    public CityEntity(Long cityid, CountryEntity country, String name) {
        this.cityid = cityid;
        this.country = country;
        this.name = name;
    }

    public CityEntity() {
    }

    public CityEntity(CityDTO cityDTO){
        this.cityid = cityDTO.getCityid();
        this.name = cityDTO.getName();
        this.country = cityDTO.getCountry();
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

