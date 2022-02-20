package com.snehal.carservice.common.util;

import com.snehal.carservice.model.dto.AppUserJsonDto;
import com.snehal.carservice.model.persistable.EmployeePersistable;
import com.snehal.carservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {
  @Autowired private EmployeeService employeeService;

  public boolean supports(Class<?> aClass) {
    return AppUserJsonDto.class.equals(aClass);
  }

  public void validate(Object o, Errors errors) {
    EmployeePersistable user = (EmployeePersistable) o;

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "NotEmpty");
    if (user.getMobileNumber().length() < 10) {
      errors.rejectValue("mobileNumber", "Please check your Mobile number");
    }

    if (employeeService.findByMobileNumber(user.getMobileNumber()) != null) {
      errors.rejectValue("mobileNumber", "Duplicate Mobile Number, Try with new Mobile Number");
    }

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
    if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
      errors.rejectValue("password", "Please provide Strong password with atleast 8 characters");
    }
  }
}
