package com.am.user_service.services;

import com.am.user_service.domain.dto.CityDTO;
import com.am.user_service.domain.dto.FilterDTO;
import com.am.user_service.domain.dto.UserDTO;
import com.am.user_service.domain.dto.UserroleDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    UserDTO activateUser(String username, String password);
    UserDTO changePassword(String username, String password , String newPassword);
    Boolean logIn(String username, String password);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO getUser(Long usrid);
    List<UserDTO> getAllUsers(Long userRoleId);
    List<UserDTO> getAllUsers();
    List<UserDTO> findUsers(FilterDTO filterDTO);
    void deleteUser(Long usrid);
    List<CityDTO> getCities();
    List<UserroleDTO> getUserRoles();

}
