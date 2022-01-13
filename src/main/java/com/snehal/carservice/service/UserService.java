package com.snehal.carservice.service;

import com.snehal.carservice.model.AppUser;
import com.snehal.carservice.model.UserVehicleDetail;

public interface UserService {
    Long save(AppUser user);
    
    AppUser findByUsername(String username);
    
    AppUser findByUserId(Long userId);
    
    UserVehicleDetail saveVehicleDetail(UserVehicleDetail userVehicleDetail);

	UserVehicleDetail getUserVehicleDetail(Long detailId);
}
