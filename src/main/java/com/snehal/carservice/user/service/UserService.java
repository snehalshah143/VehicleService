package com.snehal.carservice.user.service;

import com.snehal.carservice.common.model.AppUser;
import com.snehal.carservice.common.model.UserVehicleDetail;

public interface UserService {
    AppUser save(AppUser user);
    
    AppUser findByUsername(String username);
    
    AppUser findByUserId(Long userId);
    
    UserVehicleDetail saveVehicleDetail(UserVehicleDetail userVehicleDetail);

	UserVehicleDetail getUserVehicleDetail(Long detailId);
}
