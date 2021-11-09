package com.claimService.service;


import java.time.LocalDate;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimService.entity.ClaimDetails;
import com.claimService.error.InvalidDataException;
import com.claimService.repository.ClaimDetailsRepository;



@Service
public class ClaimDetailsServiceImpl implements ClaimDetailsService {
//	private static long id = 1000000000L;	

	private static final long LIMIT = 10000000000L;
	private static long last = 0;
	
	@Autowired
	private ClaimDetailsRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(ClaimDetailsServiceImpl.class);
	
	public ClaimDetails addClaimDetails(ClaimDetails request) throws InvalidDataException {
		logger.info("Inside service to save the claim of user " +  request.getEmail());
		LocalDate admitDate = LocalDate.parse(request.getAdmissionDate());
		LocalDate dischrgDate  = LocalDate.parse(request.getDischargeDate());
		
		if (!admitDate.isBefore(dischrgDate)) {
			throw new InvalidDataException("Discharge date must be after admission date!");
		}
		
		request.setClaimNumber(generateClaimNumber());
	
		return repository.insert(request);
	}
	
	public  long generateClaimNumber() {
		
		
		long id = System.currentTimeMillis() % LIMIT;
		
	
		if (last == id) {
			id = System.currentTimeMillis() % LIMIT;
		}
		
		
	 
	
	 
	return last = id;
	}

}
