package com.claimService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.claimService.entity.AuthRequest;
import com.claimService.repository.AuthProfileRepository;



@Service
public class AuthProfileServiceImpl implements AuthProfileService {
	
	@Autowired
	private AuthProfileRepository repository;
	
@Autowired
	private BCryptPasswordEncoder encoder;
	
private Logger logger = LoggerFactory.getLogger(AuthProfileServiceImpl.class);

	public AuthRequest getAuthDetails(String email) {
		
		logger.info("UserName lookup for authentication of "+ email);
		AuthRequest authDetails= repository.findById(email).get();
		
	
		return authDetails;
	}
}
