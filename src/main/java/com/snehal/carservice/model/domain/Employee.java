package com.snehal.carservice.model.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

public class Employee implements Serializable{
	
    private @Id  @GeneratedValue(strategy = GenerationType.TABLE) Long empId;
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
