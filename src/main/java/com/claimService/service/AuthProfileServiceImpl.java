package com.claimService.service;

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
	


	public AuthRequest getAuthDetails(String email) {
		System.out.println("Inside get Auth details() ==>"+ email);	
		AuthRequest authDetails= repository.findById(email).get();
		
	
		return authDetails;
	}
}
