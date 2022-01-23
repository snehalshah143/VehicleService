package com.snehal.carservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.snehal.carservice.dao.AppUserRepository;
import com.snehal.carservice.model.AppUser;
import com.snehal.carservice.model.LoginModel;
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public AppUser authenticateUser(LoginModel login) {

			AppUser user= userRepository.findByUsername(login.getUsername());
		if(user==null) {
			return user;
		}
		String encrytedPasswordToVerify=bCryptPasswordEncoder.encode(login.getPassword());
		if(user.getPassword().equals(login.getPassword()))
		{
			user.setLoggedIn(true);
			return user;
		}
		return user;
		}
	

}
