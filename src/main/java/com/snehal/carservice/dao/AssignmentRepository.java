package com.snehal.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.Assignment;
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
