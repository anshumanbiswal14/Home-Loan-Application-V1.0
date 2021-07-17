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
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundException;
import com.cg.homeloan.jwtsecurity.helper.JwtUtils;
import com.cg.homeloan.repositories.ILandVerificationRepository;
import com.cg.homeloan.services.ILoanApplicationService;
import com.cg.homeloan.services.LandVerificationService;

@RestController
@RequestMapping("/homeloan/landOfficer")
@CrossOrigin(origins = "*")
public class LandVerificationOfficerController {

	@Autowired
	LandVerificationService landVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	@Autowired
	ILandVerificationRepository iLandVerificationRepository;
	
	//use for jwt
	@Autowired
	private AuthenticationManager authenticationManager;
				
	@Autowired
	private JwtUtils jwtutil;

	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@PutMapping("/updateLandVerificationStatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateLandStatus(@PathVariable int loanApplicationId) throws LandVerificationException, LoanApplicationNotFoundException {
		return new ResponseEntity<>(loanApplicationService.updateLandStatus(loanApplicationId), HttpStatus.OK);

	}
	
	//Validating the user	
	@GetMapping("/validatingLandOfficer/{username}/{password}")
	public ResponseEntity<Boolean> isValidLandOfficer(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(landVerificationService.isValidLandOfficer(username, password),HttpStatus.OK);
	}
	
	
	//JWT security 
	//This method is used for Login and its sends token as a response
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody User loginRequest) {
			 
		Boolean validate =iLandVerificationRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword())!=null? true :false; 
				 
		
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
		return ResponseEntity.ok(""+landVerificationService.isValidLandOfficer(validRequest.getUsername(), validRequest.getPassword()));
	}


}
