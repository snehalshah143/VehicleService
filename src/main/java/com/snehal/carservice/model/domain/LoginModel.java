package com.snehal.carservice.model.domain;

import javax.validation.constraints.NotBlank;

public class LoginModel {

  private @NotBlank String username;
  private @NotBlank String password;

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

  public LoginModel() {}

  public LoginModel(@NotBlank String username, @NotBlank String password) {
    super();
    this.username = username;
    this.password = password;
  }
}
