package com.am.user_service.domain.dto;

import com.am.user_service.domain.entities.CountryEntity;

public class CountryDTO {

    private Long countryid;
    private String name;

    public CountryDTO(CountryEntity countryEntity){
        this.countryid = countryEntity.getCountryid();
        this.name = countryEntity.getName();
    }

    public CountryDTO() {
    }

    public CountryDTO(Long countryid, String name) {
        this.countryid = countryid;
        this.name = name;
    }

    public Long getCountryid() {
        return countryid;
    }

    public void setCountryid(Long countryid) {
        this.countryid = countryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
