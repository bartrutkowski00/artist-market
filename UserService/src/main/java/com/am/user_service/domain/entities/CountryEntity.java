package com.am.user_service.domain.entities;
import com.am.user_service.domain.dto.CountryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    private Long countryid;
    private String name;

    public CountryEntity(Long countryid, String name) {
        this.countryid = countryid;
        this.name = name;
    }

    public CountryEntity(){
    }

    public CountryEntity(CountryDTO countryDTO){
        this.countryid = countryDTO.getCountryid();
        this.name = countryDTO.getName();
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
