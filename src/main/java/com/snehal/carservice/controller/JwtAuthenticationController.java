package com.snehal.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.carservice.jwt.JwtLoginRequest;
import com.snehal.carservice.jwt.JwtResponse;
import com.snehal.carservice.jwt.JwtTokenUtil;
import com.snehal.carservice.jwt.JwtUserDetailsService;
import com.snehal.carservice.model.persistable.AppUserPersistable;
import com.snehal.carservice.service.UserService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private JwtTokenUtil jwtTokenUtil;

@Autowired
private JwtUserDetailsService userDetailsService;
@Autowired
private UserService userService;

//@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
@RequestMapping(value ="/userlogin", method = RequestMethod.POST)
public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtLoginRequest authenticationRequest) throws Exception {

return ResponseEntity.ok(login(authenticationRequest));
}

public JwtResponse login(JwtLoginRequest authenticationRequest) {
	
	try {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	final UserDetails userDetails = userDetailsService
	.loadUserByUsername(authenticationRequest.getUsername());


		AppUserPersistable appUser=userService.findByUsername(authenticationRequest.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return new JwtResponse(appUser.getUserId(),token);
}



private  void authenticate(String username, String password) throws Exception {
try {
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
} catch (DisabledException e) {
throw new Exception("USER_DISABLED", e);
} catch (BadCredentialsException e) {
throw new Exception("INVALID_CREDENTIALS", e);
}
}
}
