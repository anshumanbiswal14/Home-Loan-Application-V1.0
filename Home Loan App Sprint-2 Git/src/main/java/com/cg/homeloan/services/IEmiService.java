package com.cg.homeloan.services;

import com.cg.homeloan.entities.EMI;

public interface IEmiService {

	public EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure); 
	public double calculateEmi(double principal,double intrestRate,int tenure);
	
}