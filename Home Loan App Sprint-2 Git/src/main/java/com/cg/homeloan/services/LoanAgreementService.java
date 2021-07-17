package com.cg.homeloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.EMI;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.cg.homeloan.repositories.ILoanAgreementRepository;

@Service
public class LoanAgreementService implements ILoanAgreementService{

	@Autowired
	ILoanAgreementRepository loanAgreementRepository;
	
	// this method add LoanAgreement of specific loan application using LoanApplicationId
	@Override
	public LoanAgreement addLoanAgreement(int loanApplicationId, EMI emi) {
		LoanAgreement loanAgreement = new LoanAgreement(loanApplicationId,emi);
		return loanAgreementRepository.save(loanAgreement); 
	}
	
	// get the specific LoanAgreement using loanApplicationId
	@Override
	public LoanAgreement getLoanAgreement(int loanApplicationId) throws LoanAgreementNotFoundException {
		return loanAgreementRepository.findByLoanApplicationId(loanApplicationId).orElseThrow(() -> new LoanAgreementNotFoundException("Loan Agreement Not Found!"));
	}
		
	// for getting all the LoanAgreements 
	@Override
	public List<LoanAgreement> getAllLoanAgreements() {
		 return loanAgreementRepository.findAll();
	}
	
	// remove specific LoanAgreement using loanAgrrementId 
	@Override
	public LoanAgreement deleteLoanAgreement(int loanAgreementId) throws LoanAgreementNotFoundException {
		LoanAgreement loanAgreement = getLoanAgreement(loanAgreementId);
		loanAgreementRepository.deleteById(loanAgreementId);
		return loanAgreement;
	}
	
	// update the info of specific LoanAgreement using loanAgreementId
	@Override
	public LoanAgreement updateLoanAgreement(int loanAgreementId, LoanAgreement loanAgreement)
			throws LoanAgreementNotFoundException {
		loanAgreementRepository.findById(loanAgreementId)
				.orElseThrow(() -> new LoanAgreementNotFoundException("Loan Agreement Not Found!"));
		return loanAgreementRepository.save(loanAgreement);
	}

}