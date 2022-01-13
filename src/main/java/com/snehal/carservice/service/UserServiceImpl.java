package com.snehal.carservice.service;



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

	public Long save(AppUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
//		user.setRoles(new HashSet(roleRepository.findAll()));
		AppUser savedUser=userRepository.save(user);
		return savedUser.getId();
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
}