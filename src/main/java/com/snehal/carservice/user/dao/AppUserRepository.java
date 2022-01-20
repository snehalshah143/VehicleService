package com.snehal.carservice.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.common.model.AppUser;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);
	AppUser findByUserId(Long userId);
	AppUser findByMobileNumber(String mobileNumber);
}