package com.snehal.carservice.user.service;

import java.util.List;

import com.snehal.carservice.common.model.AppUser;
import com.snehal.carservice.common.model.UserVehicleDetail;

public interface UserService {
    AppUser save(AppUser user);
    
    AppUser findByUsername(String username);
    
    AppUser findByMobileNumber(String mobileNumber);
    
    AppUser findByUserId(Long userId);
    
    UserVehicleDetail saveVehicleDetail(UserVehicleDetail userVehicleDetail);

	UserVehicleDetail getUserVehicleDetail(Long detailId);
	
	List<UserVehicleDetail> getUserVehicleDetailsForUserId(Long userId);
}
