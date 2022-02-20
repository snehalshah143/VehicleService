package com.snehal.carservice.service;

import com.snehal.carservice.model.dto.UserSignUpRequest;
import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;
import java.util.List;

public interface UserService {
  AppUserPersistable save(AppUserPersistable user);

  AppUserPersistable findByUsername(String username);

  AppUserPersistable findByMobileNumber(String mobileNumber);

  boolean verifyPassword(UserSignUpRequest request);

  AppUserPersistable findByUserId(Long userId);

  UserVehicleDetailPersistable saveVehicleDetail(UserVehicleDetailPersistable userVehicleDetail);

  UserVehicleDetailPersistable getUserVehicleDetail(Long detailId);

  List<UserVehicleDetailPersistable> getUserVehicleDetailsForUserId(Long userId);
}
