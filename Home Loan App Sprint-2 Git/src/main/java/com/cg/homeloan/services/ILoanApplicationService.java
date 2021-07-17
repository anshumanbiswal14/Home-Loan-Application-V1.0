package com.cg.homeloan.services;

import java.util.List;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.exceptions.AdminApprovalException;
import com.cg.homeloan.exceptions.CustomerNotFoundException;
import com.cg.homeloan.exceptions.FinanceVerificationException;
import com.cg.homeloan.exceptions.LandVerificationException;
import com.cg.homeloan.exceptions.LoanAgreementNotFoundException;
import com.cg.homeloan.exceptions.LoanApplicationNotFoundException;

public interface ILoanApplicationService  {
	
	public LoanApplication addLoanApplication(int userId, double loanAppliedAmount,int loanTenureYears) throws CustomerNotFoundException;
	
	public LoanApplication updateLoanApplication(int loanApplicationId,LoanApplication loanApplication) throws LoanApplicationNotFoundException;
	public LoanApplication deleteLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundException;
	public List<LoanApplication> getAllLoanApplication();
	public LoanApplication getLoanApplication(int loanApplicationId) throws LoanApplicationNotFoundException;
	public LoanApplication updateLandStatus(int loanApplicationId) throws LandVerificationException,LoanApplicationNotFoundException;
	public LoanApplication updateFinanceStatus(int loanApplicationId) throws FinanceVerificationException, LoanApplicationNotFoundException;
	public LoanApplication updateAdminStatus(int loanApplicationId) throws AdminApprovalException, LoanApplicationNotFoundException;
	public LoanAgreement getLoanAgreement(int loanApplicationId)throws LoanAgreementNotFoundException;
	

}
