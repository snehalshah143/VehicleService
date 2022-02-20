package com.snehal.carservice.controller;

import com.snehal.carservice.common.util.EmployeeValidator;
import com.snehal.carservice.jwt.JwtEmployeeDetailsService;
import com.snehal.carservice.jwt.JwtTokenUtil;
import com.snehal.carservice.mapper.EmployeeMappers;
import com.snehal.carservice.model.dto.EmployeeJsonDto;
import com.snehal.carservice.model.dto.EmployeeSignUpRequest;
import com.snehal.carservice.model.persistable.EmployeePersistable;
import com.snehal.carservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @Autowired private EmployeeValidator employeeValidator;

  @Autowired private EmployeeService employeeService;

  @Autowired private JwtEmployeeDetailsService employeeDetailsService;

  @Autowired private JwtTokenUtil jwtTokenUtil;

  @PostMapping(path = "/empsignup", consumes = "application/json")
  public ResponseEntity<?> employeeSignUp(
      @RequestBody EmployeeSignUpRequest request, BindingResult bindingResult) {

    if (!employeeService.verifyPassword(request)) {

      return new ResponseEntity<String>(
          "Password and Password Confirm Not Matching", HttpStatus.EXPECTATION_FAILED);
    }
    EmployeePersistable emp =
        EmployeeMappers.getEmployeeMappers().mapSignUpRequestToPersistable(request);
    employeeValidator.validate(emp, bindingResult);
    if (bindingResult.hasErrors()) {
      System.out.println(bindingResult.getAllErrors().toString());
      return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
    emp.setUsername(emp.getMobileNumber());
    EmployeePersistable empPersistable = employeeService.save(emp);
    EmployeeJsonDto jsonDto =
        EmployeeMappers.getEmployeeMappers().mapPersistableToJsonDto(empPersistable);

    UserDetails userDetails = employeeDetailsService.loadUserByUsername(request.getMobileNumber());

    String token = jwtTokenUtil.generateToken(userDetails);

    jsonDto.setToken(token);
    return new ResponseEntity<EmployeeJsonDto>(jsonDto, HttpStatus.OK);
  }

}
