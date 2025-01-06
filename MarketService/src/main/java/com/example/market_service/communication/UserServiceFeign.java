package com.example.market_service.communication;

import com.example.market_service.domain.DTOs.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserServiceFeign {

    @GetMapping(path = "/users/{userid}")
    public UserDTO getUser (@PathVariable("userid") Long userid);


}
