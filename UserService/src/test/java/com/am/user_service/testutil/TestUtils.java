package com.am.user_service.testutil;


import domain.entities.CityEntity;
import domain.entities.CountryEntity;
import domain.entities.UsrEntity;
import domain.entities.UserroleEntity;


import java.util.Date;


public class TestUtils {

    public static UsrEntity createTestUser(){
        return new UsrEntity(99L,
                "TestUser",
                "test@mail.com",
                423234432,
                new CityEntity(1L, new CountryEntity(1L, "Poland"), "Wroclaw"),
                new UserroleEntity(1L, "Client"),
                new Date(),
                new Date());
    }

}
