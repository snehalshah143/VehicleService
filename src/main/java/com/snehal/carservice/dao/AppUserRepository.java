package com.snehal.carservice.dao;

import com.snehal.carservice.model.persistable.AppUserPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserPersistable, Long> {
  AppUserPersistable findByUsername(String username);

  AppUserPersistable findByUserId(Long userId);

  AppUserPersistable findByMobileNumber(String mobileNumber);
}
