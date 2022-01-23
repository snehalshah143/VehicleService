package com.snehal.carservice.service;

import com.snehal.carservice.model.AppUser;
import com.snehal.carservice.model.LoginModel;

public interface AuthenticationService {

	AppUser authenticateUser(LoginModel login);
}
