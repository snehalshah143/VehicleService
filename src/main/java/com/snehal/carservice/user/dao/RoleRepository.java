package com.snehal.carservice.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.common.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
