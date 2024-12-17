package com.am.user_service.services.impl;

import com.am.user_service.domain.dto.UserDTO;
import com.am.user_service.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO addUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO activateUser(String username, String password) {
        return null;
    }

    @Override
    public UserDTO changePassword(String username, String password) {
        return null;
    }

    @Override
    public Boolean logIn(String username, String password) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long usrid) {
        return null;
    }

    @Override
    public UserDTO getUser(Long usrid) {
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUsers(Integer type) {
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public ArrayList<UserDTO> findUsers(String email, Integer phone, String city, Integer userrole, Date createdDateFrom, Date createdDateTo) {
        return null;
    }

    @Override
    public void deleteUser(Long usrid) {

    }
}
