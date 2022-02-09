package com.muratkistan.springmvcregister.controller;

import com.muratkistan.springmvcregister.entity.UserEntity;
import com.muratkistan.springmvcregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private UserService userService;

    //Dependency with  Constructor Injection
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //Get All User From Database
    //http://localhost:8080/api/v1/users/getAll
    @GetMapping("/getAll")
    public List<UserEntity> getAllUser(){
        return userService.getAllUsers();
    }

    //Get User By Id
    //http://localhost:8080/api/v1/users/getUserById/2
    @GetMapping("/getUserById/{id}")
    public UserEntity findById(@PathVariable(name="id") Long id){
        return userService.getUserById(id);
    }

    //Delete User By Id
    //http://localhost:8080/api/v1/users/deleteById/2
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable(name="id") Long id){
        userService.deleteUserById(id);
        return id+ " numarali kullanici silindi";
    }

    //Update User By Id
    //http://localhost:8080/api/v1/users/update/2
    @GetMapping("/update/{id}")
    public UserEntity updateCustomer(@PathVariable Long id,@RequestBody UserEntity user) {


       return userService.updateCustomer(id,user);


    }



}
