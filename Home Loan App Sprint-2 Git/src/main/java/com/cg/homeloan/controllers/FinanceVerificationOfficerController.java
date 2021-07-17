package com.cg.homeloan.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.ResponseToken;
import com.cg.homeloan.entities.User;
import com.cg.homeloan.exceptions.FinanceVerificationException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundException;
import com.cg.homeloan.jwtsecurity.helper.JwtUtils;
import com.cg.homeloan.repositories.IFinanceVerificationRepository;
import com.cg.homeloan.services.FinanceVerificationService;
import com.cg.homeloan.services.ILoanApplicationService;

@RestController
@RequestMapping("/homeloan/financeOfficer")
@CrossOrigin(origins = "*")
public class FinanceVerificationOfficerController {
	
	@Autowired
	FinanceVerificationService financeVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	@Autowired
	IFinanceVerificationRepository iFinanceVerificationRepository;
	
	//use for jwt
	@Autowired
	private AuthenticationManager authenticationManager;
					
	@Autowired
	private JwtUtils jwtutil;

	
	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@PutMapping("/updateFinanceVerificationStatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateFinanceStatus(@PathVariable int loanApplicationId) throws FinanceVerificationException, LoanApplicationNotFoundException {
		return new ResponseEntity<>(loanApplicationService.updateFinanceStatus(loanApplicationId), HttpStatus.OK);

	}
	
	//Validating the user
	@GetMapping("/validatingFinanceOfficer/{username}/{password}")
	public ResponseEntity<Boolean> isValidFinanceOfficer(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(financeVerificationService.isValidFinanceOfficer(username, password),HttpStatus.OK);
	}
	
	
	//JWT Security method
	//This method is used for Login and its sends token as a response
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody User loginRequest) {
				 
		Boolean validate =iFinanceVerificationRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword())!=null? true :false; 
				 
		System.out.println(loginRequest);
		if(validate){
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			 
			SecurityContextHolder.getContext().setAuthentication(authentication);
				 
			String jwt = jwtutil.generateJwtToken(authentication);
						
			return ResponseEntity.ok(new ResponseToken(jwt));
		}else{
				return ResponseEntity.ok("User Not Found!!!");
		}

	}
				
	//Validation the User
	@PostMapping("/validatingLandOfficer")
	public ResponseEntity<?> isValidLandOfficer(@Validated @RequestBody User validRequest){
		return ResponseEntity.ok(""+financeVerificationService.isValidFinanceOfficer(validRequest.getUsername(), validRequest.getPassword()));
	}

}
