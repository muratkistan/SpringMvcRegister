package com.muratkistan.springmvcregister.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//Lombok Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class UserDto {

    @NotEmpty(message = "First Name can not be null")
    private String firstName;

    @NotEmpty(message = "Last Name can not be null")
    private String lastName;

    @NotEmpty(message = "Email can not be null")
    @Email(message="Not valid email  address")
    private String emailAddress;


    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="Password must have at least 1 uppercase,1 lowercase letter and 1 number")
    private String password;



}
