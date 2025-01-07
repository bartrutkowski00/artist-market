package com.am.user_service.services.impl;

import com.am.user_service.domain.dto.CityDTO;
import com.am.user_service.domain.dto.FilterDTO;
import com.am.user_service.domain.dto.UserDTO;
import com.am.user_service.domain.dto.UserroleDTO;
import com.am.user_service.domain.entities.UsrEntity;
import com.am.user_service.repositories.CityRepository;
import com.am.user_service.repositories.UserroleRepository;
import com.am.user_service.repositories.UsrRepository;
import com.am.user_service.security.Encryption;
import com.am.user_service.services.UserService;
import com.am.user_service.utils.Utils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {



    private UsrRepository usrRepository;
    private UserroleRepository userroleRepository;
    private CityRepository cityRepository;
    private KafkaTemplate<String, String> kafkaTemplate;

    UserServiceImpl(UsrRepository usrRepository, UserroleRepository userroleRepository, CityRepository cityRepository, KafkaTemplate<String, String> kafkaTemplate){
        this.usrRepository = usrRepository;
        this.userroleRepository = userroleRepository;
        this.cityRepository = cityRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        validateAddingSchema(userDTO);
        userDTO.setActivatedind(false);
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
    public UserDTO updateUser(UserDTO userDTO) {
        validateUpdatingSchema(userDTO);
        UsrEntity updatedValues = new UsrEntity(userDTO);
       UsrEntity currentUser = usrRepository.findById(userDTO.getUserid()).orElseThrow(()->new RuntimeException("User not found"));
       UsrEntity updatedUser = new UsrEntity(
               Utils.nvl(updatedValues.getUsrid(), currentUser.getUsrid()),
               Utils.nvl(updatedValues.getUsername(), currentUser.getUsername()),
               currentUser.getPassword(),
               currentUser.getActivatedind(),
               Utils.nvl(updatedValues.getEmail(), currentUser.getEmail()),
               Utils.nvl(updatedValues.getPhone(), currentUser.getPhone()),
               Utils.nvl(updatedValues.getCity(), currentUser.getCity()),
               Utils.nvl(updatedValues.getUserrole(), currentUser.getUserrole()),
               currentUser.getCreateddate(),
               new Date()
       );

       return new UserDTO(usrRepository.save(updatedUser));

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
    public List<UserDTO> findUsers(FilterDTO filterDTO) {

        return usrRepository.findUsers(filterDTO).stream()
                .map(UserDTO::new).collect(Collectors.toList());
    }



    @Override
    public void deleteUser(Long usrid) {
        UsrEntity toBeDeleted = usrRepository.findById(usrid).orElseThrow(()->new RuntimeException("User not found"));
        usrRepository.delete(toBeDeleted);
        kafkaTemplate.send("delete.user.orders", String.valueOf(usrid));

    }

    @Override
    public List<CityDTO> getCities() {
        return cityRepository.findAll().stream().map(CityDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<UserroleDTO> getUserRoles() {
        return userroleRepository.findAll().stream().map(UserroleDTO::new).collect(Collectors.toList());
    }

    private void validateAddingSchema(UserDTO userDTO){
        if (userDTO.getUserid() != null || userDTO.getActivatedind() != null){
            throw new RuntimeException("UserId and ActivatedInd has to be null");
        }
    }

    private void validateUpdatingSchema(UserDTO userDTO){
        if (userDTO.getUserid() != null || userDTO.getActivatedind() != null || userDTO.getCreateddate() != null){
            throw new RuntimeException("UserId, ActivatedInd and CreatedDate has to be null");
        }
    }
}
