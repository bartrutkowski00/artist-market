package com.am.user_service.controllers;

import com.am.user_service.domain.dto.CityDTO;
import com.am.user_service.domain.dto.FilterDTO;
import com.am.user_service.domain.dto.UserDTO;
import com.am.user_service.domain.dto.UserroleDTO;
import com.am.user_service.services.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<UserDTO> addUser (@RequestBody UserDTO userDTO){
       UserDTO newUser = userService.addUser(userDTO);

       return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping(path = "/users")
    public List<UserDTO> getUsers (){
        return userService.getAllUsers();
    }

    @PatchMapping(path = "/users/activate/{username}/{password}")
    public ResponseEntity<UserDTO> activateUser(@PathVariable("username") String username, @PathVariable("password") String password){
       return new ResponseEntity<UserDTO>(userService.activateUser(username, password), HttpStatus.ACCEPTED);
    }

    @PatchMapping(path = "/users/login/{username}/{password}")
    public ResponseEntity<Boolean> logIn(@PathVariable("username") String username, @PathVariable("password") String password){
        return new ResponseEntity<Boolean>(userService.logIn(username,password) , HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/users/{userid}")
    public UserDTO getUser (@PathVariable("userid") Long userid){
        return userService.getUser(userid);
    }

    @GetMapping(path = "/users/clients")
    public List<UserDTO> getClientUsers (){
        return userService.getAllUsers(1L);
    }

    @GetMapping(path = "/users/artists")
    public List<UserDTO> getArtistUsers(){
        return userService.getAllUsers(2L);
    }

    @PostMapping(path = "/users/find")
    public List<UserDTO> findUsers(@RequestBody FilterDTO filterDTO){
        return userService.findUsers(filterDTO);
    }

    @DeleteMapping(path = "/users/{userid}")
    public void deleteUser(@PathVariable("userid") Long userid ){
        userService.deleteUser(userid);
    }

    @GetMapping(path = "/cities")
    public List<CityDTO> getCities(){
        return  userService.getCities();
    }

    @GetMapping(path = "/users/roles")
    public List<UserroleDTO> getUserRoles(){
        return userService.getUserRoles();
    }

}
