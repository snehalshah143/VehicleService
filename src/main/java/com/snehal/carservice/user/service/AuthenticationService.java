package com.snehal.carservice.user.service;

import com.snehal.carservice.common.model.LoginModel;

public interface AuthenticationService {

	boolean authenticateUser(LoginModel login);
}
