package com.snehal.carservice.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.snehal.carservice.dao.AppUserRepository;
import com.snehal.carservice.dao.RoleRepository;
import com.snehal.carservice.dao.UserVehicleDetailRepository;
import com.snehal.carservice.model.AppUser;
import com.snehal.carservice.model.UserVehicleDetail;



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

	public AppUser save(AppUser user) {
//		String password=user.getPassword();
//		String passwordConfirm=user.getPasswordConfirm();
//		user.setPassword(bCryptPasswordEncoder.encode(password));
//		user.setPasswordConfirm(bCryptPasswordEncoder.encode(passwordConfirm));
//		user.setRoles(new HashSet(roleRepository.findAll()));
		AppUser savedUser=userRepository.save(user);
		return savedUser;
	}

	public AppUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	public AppUser findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}
	public UserVehicleDetail saveVehicleDetail(UserVehicleDetail userVehicleDetail) {

		return vehicleDetailRepository.save(userVehicleDetail);
	}
	
	public UserVehicleDetail getUserVehicleDetail(Long detailId) {
		return vehicleDetailRepository.findByDetailId(detailId);
		
		
	}
	public List<UserVehicleDetail> getUserVehicleDetailsForUserId(Long userId) {
		AppUser appUser=  userRepository.findById(userId).get();
		
		
		return new ArrayList(appUser.getVehicleDetails());
	}

	@Override
	public AppUser findByMobileNumber(String mobileNumber) {
		return userRepository.findByMobileNumber(mobileNumber);
	}
	
	
}