package com.snehal.carservice.dao;

import com.snehal.carservice.model.persistable.AssignmentPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentPersistable, Long> {}
