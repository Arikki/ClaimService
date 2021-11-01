package com.claimService.service;

import com.claimService.entity.AuthRequest;

public interface AuthProfileService {

	
	public AuthRequest getAuthDetails (String email);
	
}
