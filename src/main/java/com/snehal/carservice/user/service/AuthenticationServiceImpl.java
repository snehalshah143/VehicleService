package com.snehal.carservice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.snehal.carservice.common.model.AppUser;
import com.snehal.carservice.common.model.LoginModel;
import com.snehal.carservice.user.dao.AppUserRepository;
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public boolean authenticateUser(LoginModel login) {

			AppUser user= userRepository.findByUsername(login.getUsername());
		if(user==null) {
			return false;
		}
		String encrytedPasswordToVerify=bCryptPasswordEncoder.encode(login.getPassword());
		if(user.getPassword().equals(login.getPassword()))
		{return true;
		}
		return false;
		}
	

}
