package com.claimService.controller;



import org.springframework.beans.factory.annotation.Autowired;






import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.claimService.entity.ClaimDetails;
import com.claimService.error.InvalidDataException;
import com.claimService.service.ClaimDetailsService;


@RestController
@CrossOrigin
public class ClaimsServiceController {
	
	
	
	
	
	
	@Autowired
	private ClaimDetailsService claimDetailsSvc;


	
	
	
	
	
	@PostMapping("/claims")
	public ClaimDetails addClaimDetails(@RequestBody ClaimDetails details ) throws InvalidDataException {
		
		return claimDetailsSvc.addClaimDetails(details);
	}
	
	}
