package com.am.user_service.services;

import com.am.user_service.domain.dto.UserDTO;

import java.util.ArrayList;
import java.util.Date;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    UserDTO activateUser(String username, String password);
    UserDTO changePassword(String username, String password);
    Boolean logIn(String username, String password);
    UserDTO updateUser(Long usrid);
    UserDTO getUser(Long usrid);
    ArrayList<UserDTO> getAllUsers(Integer type);
    ArrayList<UserDTO> getAllUsers();
    ArrayList<UserDTO> findUsers(String email, Integer phone, String city, Integer userrole, Date createdDateFrom,Date createdDateTo);
    void deleteUser(Long usrid);

}
