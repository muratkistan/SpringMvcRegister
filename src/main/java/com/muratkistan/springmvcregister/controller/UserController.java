package com.muratkistan.springmvcregister.controller;

import com.muratkistan.springmvcregister.dto.UserDto;
import com.muratkistan.springmvcregister.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class UserController {

    private UserService userService;

    //Constructor Dependency Injection
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Show Form Page in UI
    //http://localhost:8080/register
    @GetMapping("/register")
    public String getRegisterForm(Model model){
        model.addAttribute("key_register",new UserDto());
        return "register";
    }

    //Post Form with UserDto Data
    //http://localhost:8080/register
    @PostMapping("/register")
    public String postRegisterForm(@Valid @ModelAttribute("key_register") UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Error! ");
            return "register";
        }
        userService.saveUser(userDto);
        return "login";
    }

    //Show Login Form in UI
    //http://localhost:8080/login
    @GetMapping("/login")
    public String getLoginForm(Model model){
        model.addAttribute("key_login",new UserDto());
        return "login";
    }

    //Post Login Form
    //http://localhost:8080/login
    @PostMapping("/login")
    public String postLoginForm(@Valid @ModelAttribute("key_login") UserDto userDto, BindingResult bindingResult){
        //Error check for validation
        if(bindingResult.hasErrors()){
            log.error("Error! ");
            return "register";
        }

        //if there is no error go to succes page
        userService.saveUser(userDto);
        return "success";
    }


}
