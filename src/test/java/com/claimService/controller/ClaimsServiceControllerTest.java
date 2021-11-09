package com.claimService.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.claimService.entity.ClaimDetails;
import com.claimService.error.InvalidDataException;
import com.claimService.service.ClaimDetailsService;
import com.claimService.service.UserService;

@WebMvcTest(ClaimsServiceController.class)
class ClaimsServiceControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClaimDetailsService service;
	
//	@Autowired
//	private UserService userService;
//	
	private ClaimDetails claims;
	
	@BeforeEach
	void setup() {
		claims = ClaimDetails.builder()
				  .admissionDate("2020-04-05")
				  .billAmount("250000")
				  .claimNumber(0L)
				  .dischargeDate("2021-04-05")
				  .dob("1995-11-04")
				  .email("xyz@gmail.com")
				  .firstName("Rick")
				  .lastName("Sanchez")
				  .providerName("Star Health Insurance")
				  .build();
	}

	@Test
	void testAddClaimDetails() {
		 ClaimDetails returnValue =  ClaimDetails.builder()
				  .admissionDate("2020-04-05")
				  .billAmount("250000")
				  .claimNumber(9871234560L)
				  .dischargeDate("2021-04-05")
				  .dob("1995-11-04")
				  .email("xyz@gmail.com")
				  .firstName("Rick")
				  .lastName("Sanchez")
				  .providerName("Star Health Insurance")
				  .build();
		
		try {
			Mockito.when(service.addClaimDetails(claims)).thenReturn(returnValue);
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			mockMvc.perform(post("/claims")
												.contentType(MediaType.APPLICATION_JSON)
												.content( 
														"{\n" +
																"\t\"admissionDate\": \"2021-09-01\",\n" +
																"\t\"billAmount\": \"5000\",\n" +
																"\t\"claimNumber\": \"\",\n" +
																"\t\"dischargeDate\": \"2021-10-01\",\n" +
																"\t\"dob\": \"1996-11-04\",\n" +
																"\t\"email\": \"abc@gmail.com\",\n" +
																"\t\"firstName\": \"Rick\",\n" +
																"\t\"lastName\": \"Sanchez\",\n" +
																"\t\"memberId\": \"R-123\",\n" +
																"\t\"providerName\" : \"ABC company\"\n" +
																"}"
												)).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
