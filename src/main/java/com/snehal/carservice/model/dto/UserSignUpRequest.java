package com.snehal.carservice.model.dto;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class UserSignUpRequest implements Serializable {

  private @NotBlank String password;
  private @NotBlank String passwordConfirm;
  private @NotBlank String email;
  private @NotBlank String mobileNumber;
  private @NotBlank String firstName;
  private @NotBlank String lastName;

  public UserSignUpRequest() {}

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
}
