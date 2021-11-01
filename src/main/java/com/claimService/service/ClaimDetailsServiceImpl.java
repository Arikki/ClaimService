package com.claimService.service;


import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimService.entity.ClaimDetails;
import com.claimService.error.InvalidDataException;
import com.claimService.repository.ClaimDetailsRepository;



@Service
public class ClaimDetailsServiceImpl implements ClaimDetailsService {
//	private static long id = 1000000000L;	

	@Autowired
	private ClaimDetailsRepository repository;
	
	public ClaimDetails addClaimDetails(ClaimDetails request) throws InvalidDataException {
		
		LocalDate admitDate = LocalDate.parse(request.getAdmissionDate());
		LocalDate dischrgDate  = LocalDate.parse(request.getDischargeDate());
		
		if (!admitDate.isBefore(dischrgDate)) {
			throw new InvalidDataException("Discharge date must be after admission date!");
		}
		
		request.setClaimNumber(generateClaimNumber());
	
		return repository.insert(request);
	}
	
	private long generateClaimNumber() {
	  long claimNum = 1000000000L;
	  
	 
	
	 
	return claimNum;
	}

}
