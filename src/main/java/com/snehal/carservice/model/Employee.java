package com.snehal.carservice.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
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
	public Employee(String username, @NotBlank String password, @NotBlank String passwordConfirm,
			@NotBlank String email, @NotBlank String mobileNumber, @NotBlank String firstName,
			@NotBlank String lastName, @NotBlank String address, @NotBlank boolean loggedIn, @NotBlank String role) {
		super();
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.loggedIn = loggedIn;
		this.role = role;
	}
	public Employee() {
		super();
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    
}
