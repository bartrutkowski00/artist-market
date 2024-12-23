package com.am.user_service.testutil;


import com.am.user_service.domain.dto.UserDTO;
import com.am.user_service.domain.entities.CityEntity;
import com.am.user_service.domain.entities.CountryEntity;
import com.am.user_service.domain.entities.UsrEntity;
import com.am.user_service.domain.entities.UserroleEntity;


import java.util.Date;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class TestUtils {

    public static UsrEntity createTestUser(){


        return new UsrEntity(null,
                "TestUser",
                "TestPassword",
                FALSE,
                "test@mail.com",
                423234432,
                new CityEntity(1L, new CountryEntity(1L, "Poland"), "Wroclaw"),
                new UserroleEntity(1L, "Client"),
                new Date(),
                new Date());
    }

    public static UserDTO createTestUserDTO(Long id){


        return new UserDTO("TestUser",
                "TestPassword",
                id,
                "test@mail.com",
                423234432,
                new CityEntity(1L, new CountryEntity(1L, "Poland"), "Wroclaw"),
                new Date(),
                new Date(),
                new UserroleEntity(1L, "Client"),
                FALSE);
    }


    public static UserDTO createTestUserDTO(Long id, String username){


        return new UserDTO(username,
                "TestPassword",
                id,
                "test@mail.com",
                423234432,
                new CityEntity(1L, new CountryEntity(1L, "Poland"), "Wroclaw"),
                new Date(),
                new Date(),
                new UserroleEntity(1L, "Client"),
                FALSE);
    }

    public static UserDTO createTestUserForUpdatingDTO(Long id, String username, String email){


        return new UserDTO(username,
                null,
                id,
                email,
                null,
                null,
                null,
                null,
                null,
                null );
    }



}
