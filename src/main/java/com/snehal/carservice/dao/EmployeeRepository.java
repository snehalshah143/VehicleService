package com.snehal.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.model.persistable.EmployeePersistable;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePersistable, Long> {

	EmployeePersistable findByUsername(String username);
	EmployeePersistable findByUserId(Long userId);
	EmployeePersistable findByMobileNumber(String mobileNumber);
}