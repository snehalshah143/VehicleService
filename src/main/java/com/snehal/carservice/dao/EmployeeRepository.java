package com.snehal.carservice.dao;

import com.snehal.carservice.model.persistable.EmployeePersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePersistable, Long> {

  EmployeePersistable findByUsername(String username);

  EmployeePersistable findByEmpId(Long userId);

  EmployeePersistable findByMobileNumber(String mobileNumber);
}
