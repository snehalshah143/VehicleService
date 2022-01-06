package com.snehal.carservice.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
