package com.snehal.carservice.service;

import com.snehal.carservice.model.dto.EmployeeSignUpRequest;
import com.snehal.carservice.model.persistable.EmployeePersistable;

public interface EmployeeService {
  EmployeePersistable save(EmployeePersistable user);

  EmployeePersistable findByUsername(String username);

  EmployeePersistable findByMobileNumber(String mobileNumber);

  boolean verifyPassword(EmployeeSignUpRequest request);

  EmployeePersistable findByUserId(Long userId);
}
