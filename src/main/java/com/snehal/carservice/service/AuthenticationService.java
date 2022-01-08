package com.snehal.carservice.service;

import com.snehal.carservice.model.LoginModel;

public interface AuthenticationService {

	boolean authenticateUser(LoginModel login);
}
