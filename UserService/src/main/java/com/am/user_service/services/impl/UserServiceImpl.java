package com.am.user_service.services.impl;

import com.am.user_service.domain.dto.UserDTO;
import com.am.user_service.domain.entities.UsrEntity;
import com.am.user_service.repositories.UsrRepository;
import com.am.user_service.security.Encryption;
import com.am.user_service.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private UsrRepository usrRepository;

    UserServiceImpl(UsrRepository usrRepository){
        this.usrRepository = usrRepository;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        var userVerification =  usrRepository.findByUsername(userDTO.getUsername());
        if(!userVerification.isEmpty() || userDTO.getUserid() != null){
            throw new RuntimeException("User with that username already exists.");
        }else {
            UsrEntity usrEntityToBeSaved = new UsrEntity(userDTO);
            UsrEntity savedUsr = usrRepository.save(usrEntityToBeSaved);
            return new UserDTO(savedUsr);
        }
    }

    @Override
    public UserDTO activateUser(String username, String password) {
       Optional<UsrEntity> userEntity = usrRepository.findByUsernameAndPassword(username, Encryption.encrypt(password));
       if(userEntity.isEmpty()){
           throw new RuntimeException("User not found");
       }else if(userEntity.get().getActivatedind()){
           throw new RuntimeException("User already activated");
       }else {
           UsrEntity userToBeActivated = userEntity.get();
           userToBeActivated.setActivatedind(Boolean.TRUE);
           return new UserDTO(usrRepository.save(userToBeActivated));
       }
    }

    @Override
    public UserDTO changePassword(String username, String password, String newPassword) {
        Optional<UsrEntity> userEntity = usrRepository.findByUsernameAndPassword(username, Encryption.encrypt(password));
        if(userEntity.isEmpty()){
            throw new RuntimeException("User not found");
        }else {
            UsrEntity userChangedPassword = userEntity.get();
            userChangedPassword.setPassword(Encryption.encrypt(newPassword));
            return new UserDTO(usrRepository.save(userChangedPassword));
        }
    }

    @Override
    public Boolean logIn(String username, String password) {
        Optional<UsrEntity> userEntity = usrRepository.findByUsernameAndPassword(username, Encryption.encrypt(password));
        if(userEntity.isEmpty()){
            throw new RuntimeException("Username or password invalid.");
        }else {
            return true;
        }
    }

    @Override
    public UserDTO updateUser(Long usrid) {
        return null;
    }

    @Override
    public UserDTO getUser(Long usrid) {
        Optional<UsrEntity> userEntity = usrRepository.findById(usrid);
        if(userEntity.isEmpty()){
            throw new RuntimeException("User not found.");
        }else {
            return new UserDTO(userEntity.get());
        }
    }

    @Override
    public List<UserDTO> getAllUsers(Long userRoleID) {
        return usrRepository.findAll().stream()
                .filter(usrEntity -> usrEntity.getUserrole().getUserroleid().equals(userRoleID))
                .map(UserDTO::new)
                .limit(200)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return usrRepository.findAll().stream()
                .map(UserDTO::new)
                .limit(200)
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<UserDTO> findUsers(String email, Integer phone, String city, Integer userrole, Date createdDateFrom, Date createdDateTo) {
        return null;
    }

    @Override
    public void deleteUser(Long usrid) {

    }
}
