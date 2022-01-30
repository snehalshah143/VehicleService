package com.snehal.carservice.jwt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snehal.carservice.dao.AppUserRepository;
import com.snehal.carservice.model.persistable.AppUserPersistable;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserRepository userRepository;
	
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	AppUserPersistable user = userRepository.findByUsername(username);

/*        Set<GrantedAuthority> grantedAuthorities = new HashSet();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

        */
    	
		if (user!=null) {
			return new User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
			
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
