package com.snehal.carservice.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snehal.carservice.dao.AppUserRepository;
import com.snehal.carservice.dao.RoleRepository;
import com.snehal.carservice.dao.UserVehicleDetailRepository;
import com.snehal.carservice.model.dto.UserSignUpRequest;
import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.model.persistable.UserVehicleDetailPersistable;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserVehicleDetailRepository vehicleDetailRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional(rollbackFor = Exception.class)
	public AppUserPersistable save(AppUserPersistable user) {
		String password=user.getPassword();

		user.setPassword(bCryptPasswordEncoder.encode(password));
//		user.setRoles(new HashSet(roleRepository.findAll()));
		AppUserPersistable savedUser=userRepository.save(user);
		return savedUser;
	}

 public boolean verifyPassword(UserSignUpRequest request ){
	  
	 return request.getPassword().equals(request.getPasswordConfirm());
  }
	
	public AppUserPersistable findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	public AppUserPersistable findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}
	public UserVehicleDetailPersistable saveVehicleDetail(UserVehicleDetailPersistable userVehicleDetail) {

		return vehicleDetailRepository.save(userVehicleDetail);
	}
	
	public UserVehicleDetailPersistable getUserVehicleDetail(Long detailId) {
		return vehicleDetailRepository.findByDetailId(detailId);
		
		
	}
	public List<UserVehicleDetailPersistable> getUserVehicleDetailsForUserId(Long userId) {
		AppUserPersistable appUser=  userRepository.findById(userId).get();
		
		
		return new ArrayList(appUser.getVehicleDetails());
	}

	@Override
	public AppUserPersistable findByMobileNumber(String mobileNumber) {
		return userRepository.findByMobileNumber(mobileNumber);
	}
	
	
}