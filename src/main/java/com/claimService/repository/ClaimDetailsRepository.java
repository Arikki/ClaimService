package com.claimService.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.claimService.entity.ClaimDetails;


public interface ClaimDetailsRepository extends MongoRepository<ClaimDetails, String>{
	

}
