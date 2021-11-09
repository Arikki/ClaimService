package com.claimService.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.claimService.entity.ClaimDetails;
import com.claimService.error.InvalidDataException;
import com.claimService.repository.ClaimDetailsRepository;

@SpringBootTest
class ClaimDetailsServiceTest {
	
	@Autowired
	private ClaimDetailsService claimDetailsSvc;
	
	@MockBean
	private ClaimDetailsRepository repository;
	

	@Test
	void addClaim_whenValidData_shouldBeAdded() {
		
		ClaimDetails claims = new ClaimDetails("ricky@gmail.com","R-123", "Rick", "Sanchez",
												"1995-05-04", "2021-10-09", "2021-11-01", "HDFC",
												 "25000",0L);
		ClaimDetails insertedClaim = new ClaimDetails("ricky@gmail.com","R-123", "Rick", "Sanchez",
				"1995-05-04", "2021-10-09", "2021-11-01", "HDFC",
				 "25000",9874561230L);
		
		Mockito.when(repository.insert(claims)).thenReturn(insertedClaim);

		ClaimDetailsServiceImpl service = Mockito.mock(ClaimDetailsServiceImpl.class);
		Mockito.when(service.generateClaimNumber()).thenReturn(9874561230L);
		
		
		ClaimDetails submittedClaim = null;
		try {
			submittedClaim = claimDetailsSvc.addClaimDetails(claims);
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(insertedClaim, submittedClaim);
	}
	
	@Test
	void addClaim_whenInvalidData_exceptionShouldBeThrown() {
		ClaimDetails claims = new ClaimDetails("ricky@gmail.com","R-123", "Rick", "Sanchez",
				"1995-05-04", "2021-10-09", "2021-08-01", "HDFC",
				 "25000",0L);
		
		String expectedMsg = "Discharge date must be after admission date!";
		Exception exception = assertThrows(InvalidDataException.class, ()-> {
			claimDetailsSvc.addClaimDetails(claims);
			
		});
		
		assertTrue(expectedMsg.contains(exception.getMessage()));
		
	}

}
