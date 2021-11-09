package com.claimService.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


	private Logger logger = LoggerFactory.getLogger(ClaimsServiceController.class);
	
	
	
	
	@PostMapping("/claims")
	public ClaimDetails addClaimDetails(@RequestBody ClaimDetails details ) throws InvalidDataException {
		
		logger.info("Inside controller to add a claim for user" + details.getEmail());
		return claimDetailsSvc.addClaimDetails(details);
	}
	
	}
