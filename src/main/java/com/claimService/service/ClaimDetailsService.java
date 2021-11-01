package com.claimService.service;

import com.claimService.entity.ClaimDetails;
import com.claimService.error.InvalidDataException;

public interface ClaimDetailsService {
	
	public ClaimDetails addClaimDetails(ClaimDetails request) throws InvalidDataException ;

}
