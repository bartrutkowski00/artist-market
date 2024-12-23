package com.am.user_service.domain.dto;

import com.am.user_service.domain.entities.CityEntity;
import com.am.user_service.domain.entities.CountryEntity;


public class CityDTO {

    private Long cityid;
    private CountryEntity country;
    private String name;

    public CityDTO(CityEntity cityEntity){
        this.cityid = cityEntity.getCityid();
        this.country = cityEntity.getCountry();
        this.name = cityEntity.getName();
    }

    public CityDTO() {
    }

    public CityDTO(Long cityid, CountryEntity country, String name) {
        this.cityid = cityid;
        this.country = country;
        this.name = name;
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
