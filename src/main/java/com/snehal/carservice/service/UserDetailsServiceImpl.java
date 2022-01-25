package com.snehal.carservice.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snehal.carservice.dao.AppUserRepository;
import com.snehal.carservice.model.persistable.AppUserPersistable;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private AppUserRepository userRepository;
	
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	AppUserPersistable user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet();
/*        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }*/

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}