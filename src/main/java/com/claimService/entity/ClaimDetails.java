package com.claimService.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class ClaimDetails {
	
	
	private String email;
	private String memberId;
	private String firstName;
	private String lastName;
	private String dob;
	private String admissionDate;
	private String dischargeDate;
	private String providerName;
	private String billAmount;
	private Long claimNumber;
	

}
