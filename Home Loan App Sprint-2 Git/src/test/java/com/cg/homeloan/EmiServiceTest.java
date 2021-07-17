package com.cg.homeloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.homeloan.repositories.IEmiRepository;
import com.cg.homeloan.services.IEmiService;

@SpringBootTest
class EmiServiceTest {
	@Autowired
	IEmiService emiService;
	
	@MockBean
	IEmiRepository emiRepository;
	
	@Test
	@DisplayName("Test Case for Valid Emi Calculator")
	void testEmiCalculatorValid() {
		assertEquals(19822.61053226429, emiService.calculateEmi(1500000, 10, 10));
	}
	
	@Test
	@DisplayName("Test Case for Invalid Emi Calculator")
	void testEmiCalculatorInvalid() {
		assertNotEquals(20000, emiService.calculateEmi(1500000, 10, 10));
	}
	
}
