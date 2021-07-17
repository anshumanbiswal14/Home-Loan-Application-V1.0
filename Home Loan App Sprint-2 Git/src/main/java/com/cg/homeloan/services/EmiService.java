package com.cg.homeloan.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.EMI;
import com.cg.homeloan.repositories.IEmiRepository;

@Service
public class EmiService implements IEmiService {
	@Autowired
	IEmiRepository emiRepository;
	
	
	/*
	 * this method add emi details to the loan application when loan is approved
	 */
	@Override
	public EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure) {
		double emiAmount =calculateEmi(loanAppliedAmount,intrestRate,tenure);
		double loanAmount = emiAmount * 12 * tenure;
		EMI emi = new EMI();
		emi.setDueDate(LocalDate.now().plusYears(tenure));
		emi.setEmiAmount(emiAmount);
		emi.setLoanAmount(loanAmount);
		emi.setInterestAmount(loanAmount-loanAppliedAmount);
		
		return emiRepository.save(emi);
	}
	
	
	/*
	 * this method calculate the emi for customer
	 */
	@Override
	public double calculateEmi(double principal,double intrestRate,int tenure) {
		intrestRate = intrestRate/(12*100);
		tenure = 12 * tenure;
		return (principal * intrestRate * Math.pow(1 + intrestRate, tenure)) / (Math.pow(1 + intrestRate, tenure) - 1);
	}
}