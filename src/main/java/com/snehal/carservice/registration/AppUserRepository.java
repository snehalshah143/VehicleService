package com.snehal.carservice.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.AppUser;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);
	AppUser findByUserId(Long userId);
}