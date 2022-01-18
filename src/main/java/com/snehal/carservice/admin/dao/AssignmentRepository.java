package com.snehal.carservice.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.common.model.Assignment;
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
