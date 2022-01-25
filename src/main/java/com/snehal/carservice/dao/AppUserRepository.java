package com.snehal.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.persistable.AppUserPersistable;
@Repository
public interface AppUserRepository extends JpaRepository<AppUserPersistable, Long> {
	AppUserPersistable findByUsername(String username);
	AppUserPersistable findByUserId(Long userId);
	AppUserPersistable findByMobileNumber(String mobileNumber);
}