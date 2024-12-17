package com.am.user_service.testutil;


import com.am.user_service.domain.entities.CityEntity;
import com.am.user_service.domain.entities.CountryEntity;
import com.am.user_service.domain.entities.UsrEntity;
import com.am.user_service.domain.entities.UserroleEntity;


import java.util.Date;

import static java.lang.Boolean.TRUE;


public class TestUtils {

    public static UsrEntity createTestUser(){
        return new UsrEntity(99L,
                "TestUser",
                "TestPassword",
                TRUE,
                "test@mail.com",
                423234432,
                new CityEntity(1L, new CountryEntity(1L, "Poland"), "Wroclaw"),
                new UserroleEntity(1L, "Client"),
                new Date(),
                new Date());
    }

}
