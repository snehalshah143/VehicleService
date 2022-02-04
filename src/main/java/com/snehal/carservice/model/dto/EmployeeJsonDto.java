package com.snehal.carservice.model.dto;

import javax.validation.constraints.NotBlank;

public class EmployeeJsonDto extends AbstractJsonDto{
	
    private Long empId;
    private String username;
    private @NotBlank String password;
    private @NotBlank String passwordConfirm;
    private @NotBlank String email;
    private @NotBlank String mobileNumber;
    private @NotBlank String firstName;
    private @NotBlank String lastName;
    private @NotBlank String address;
    private @NotBlank boolean loggedIn;
    private @NotBlank String role;


    
}
