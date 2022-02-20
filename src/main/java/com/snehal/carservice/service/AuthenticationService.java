package com.snehal.carservice.service;

import com.snehal.carservice.model.domain.LoginModel;
import com.snehal.carservice.model.persistable.AppUserPersistable;

public interface AuthenticationService {

  AppUserPersistable authenticateUser(LoginModel login);
}
