package com.muratkistan.springmvcregister.service;

import com.muratkistan.springmvcregister.dto.UserDto;
import com.muratkistan.springmvcregister.entity.UserEntity;
import com.muratkistan.springmvcregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Add User to database
    public void saveUser(UserDto userDto){

        UserEntity user = UserEntity
                .builder()
                .id(0L)
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .emailAddress(userDto.getEmailAddress())
                .password(userDto.getPassword())
                .build();
        userRepository.save(user);
    }

    //Get All users From Database
    public List<UserEntity> getAllUsers(){
        return (List<UserEntity>) userRepository.findAll();
    }


    //Get User By id
    public UserEntity getUserById( Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public UserEntity updateCustomer(Long id,UserEntity user) {

        Optional<UserEntity>  optional = userRepository.findById(id);

        UserEntity oldUser= optional.get();

        oldUser.setId(id);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmailAddress(user.getEmailAddress());
        oldUser.setPassword(user.getPassword());

        return userRepository.save(oldUser);
    }

    //Delete user by id from database
    public void deleteUserById(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }

    }



}
