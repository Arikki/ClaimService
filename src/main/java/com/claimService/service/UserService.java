package com.claimService.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.claimService.entity.AuthRequest;



@Service
public class UserService implements UserDetailsService {
    
	
	
	@Autowired
	private AuthProfileService authProfileSvc;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		AuthRequest authDetails = authProfileSvc.getAuthDetails(username);
		
		
		
		
		return new User(authDetails.getEmail(),authDetails.getPassword(),new ArrayList<>());
		
		

		
	}

}
