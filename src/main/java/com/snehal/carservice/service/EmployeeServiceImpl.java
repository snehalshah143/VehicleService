package com.snehal.carservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.snehal.carservice.dao.EmployeeRepository;
import com.snehal.carservice.model.dto.EmployeeSignUpRequest;
import com.snehal.carservice.model.persistable.EmployeePersistable;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public EmployeePersistable save(EmployeePersistable emp) {
		String password=emp.getPassword();

		emp.setPassword(bCryptPasswordEncoder.encode(password));
//		user.setRoles(new HashSet(roleRepository.findAll()));
		EmployeePersistable savedUser=employeeRepository.save(emp);
		return savedUser;
	}

	@Override
	public EmployeePersistable findByUsername(String username) {
		return employeeRepository.findByUsername(username);
	}

	@Override
	public EmployeePersistable findByMobileNumber(String mobileNumber) {
		return employeeRepository.findByMobileNumber(mobileNumber);
	}

	@Override
	public boolean verifyPassword(EmployeeSignUpRequest request) {
		 return request.getPassword().equals(request.getPasswordConfirm());
	}

	@Override
	public EmployeePersistable findByUserId(Long userId) {
		return employeeRepository.findByUserId(userId);
	}

}
