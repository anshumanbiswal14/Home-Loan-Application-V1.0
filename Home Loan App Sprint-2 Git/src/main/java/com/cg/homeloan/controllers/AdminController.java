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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.entities.Admin;
import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.ResponseToken;
import com.cg.homeloan.entities.User;
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundException;
import com.cg.homeloan.jwtsecurity.helper.JwtUtils;
import com.cg.homeloan.repositories.IAdminRepository;
import com.cg.homeloan.services.CustomerService;
import com.cg.homeloan.services.IAdminService;
import com.cg.homeloan.services.IFinanceVerificationService;
import com.cg.homeloan.services.ILandVerificationService;
import com.cg.homeloan.services.ILoanApplicationService;
import com.cg.homeloan.services.LoanAgreementService;

@RestController
@RequestMapping("/homeloan/admin")
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@Autowired
	private IAdminRepository iAdminRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	IFinanceVerificationService financeVerificationService;
	
	@Autowired
	ILandVerificationService landVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	@Autowired
	LoanAgreementService loanAgreementService;
	
	
	//use for jwt
	@Autowired
	private AuthenticationManager authenticationManager;
				
	@Autowired
	private JwtUtils jwtutil;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.OK);
	}
	
	@PostMapping("/addFinanceOfficer")
	public ResponseEntity<FinanceVerificationOfficer> addFinanceOfficer(@RequestBody FinanceVerificationOfficer officer) {
		return new ResponseEntity<>(financeVerificationService.addFinanceOfficer(officer), HttpStatus.OK);
	}
	
	@PostMapping("/addLandOfficer")
	public ResponseEntity<LandVerificationOfficer> addLandOfficer(@RequestBody LandVerificationOfficer officer) {
		return new ResponseEntity<>(landVerificationService.addLandOfficer(officer),HttpStatus.OK);
	}	
	
	@GetMapping("/{userId}")
	public ResponseEntity<Admin> viewAdmin(@PathVariable("userId") int userId) {
		return new ResponseEntity<>(adminService.getAdmin(userId), HttpStatus.OK);
	}
	
	@GetMapping("/Admins")
	public ResponseEntity<List<Admin>> viewAllAdmin() {
		return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@GetMapping("/LoanAgreements")
	public ResponseEntity<List<LoanAgreement>> getAllAgreementList() {
		return new ResponseEntity<>(loanAgreementService.getAllLoanAgreements(), HttpStatus.OK);
	}
	
	@PutMapping("/updateAdminVerificationStatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateAdminStatus(@PathVariable int loanApplicationId) throws AdminApprovalException, LoanApplicationNotFoundException {
		return new ResponseEntity<>(loanApplicationService.updateAdminStatus(loanApplicationId), HttpStatus.OK);

	}
	
	@PutMapping("/updateLoanApplication")
	public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable int loanApplicationId, @RequestBody LoanApplication loanApplication) throws LoanApplicationNotFoundException {
		return new ResponseEntity<>(loanApplicationService.updateLoanApplication(loanApplicationId,loanApplication), HttpStatus.OK);
	}
	
	@PutMapping("/updateLoanAgreement")
	public ResponseEntity<LoanAgreement> updateLoanAgreement(@PathVariable int loanAgreementId,@RequestBody LoanAgreement loanAgreement) throws LoanAgreementNotFoundException {
		return new ResponseEntity<>(loanAgreementService.updateLoanAgreement(loanAgreementId, loanAgreement), HttpStatus.OK);
	}
	
	//Validating the user
	@GetMapping("/validatingAdmin/{username}/{password}")
	public ResponseEntity<Boolean> isValidAdmin(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(adminService.isValidAdmin(username, password),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{userId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int userId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.deleteCustomer(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> deleteLoanApplication(@PathVariable int loanApplicationId) throws LoanApplicationNotFoundException {
		return new ResponseEntity<>(loanApplicationService.deleteLoanApplication(loanApplicationId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLoanAgreement/{loanAgreementId}")
	public ResponseEntity<LoanAgreement> deleteLoanAgreement(@PathVariable int loanAgreementId) throws LoanAgreementNotFoundException {
		return new ResponseEntity<>(loanAgreementService.deleteLoanAgreement(loanAgreementId), HttpStatus.OK);
	}
	
	
	//JWT Methods
	//This method is used for Login and its sends token as a response
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody User loginRequest) {
		 
		Boolean validate =iAdminRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword())!=null? true :false; 
			 
		System.out.println(loginRequest);
		if(validate){
			Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		 
			SecurityContextHolder.getContext().setAuthentication(authentication);
		 
			String jwt = jwtutil.generateJwtToken(authentication);
				
			return ResponseEntity.ok(new ResponseToken(jwt));
		}
		else {
				return ResponseEntity.ok("User Not Found!!!");
		}

	}
		
	//Validate the User
	@PostMapping("/validatingAdmin")
	public ResponseEntity<?> isValidAdmin(@Validated @RequestBody User validRequest){
		return ResponseEntity.ok(""+adminService.isValidAdmin(validRequest.getUsername(), validRequest.getPassword()));
	}
	
}