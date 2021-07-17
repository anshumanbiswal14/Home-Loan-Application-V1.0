package com.cg.homeloan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.repositories.IFinanceVerificationRepository;

@Service
public class FinanceVerificationService implements IFinanceVerificationService {

	@Autowired
	IFinanceVerificationRepository iFinanceVerificationRepository;
	
	// saving a specific record by using the method save() of CrudRepository
	public FinanceVerificationOfficer addFinanceOfficer(FinanceVerificationOfficer officer) {
		iFinanceVerificationRepository.save(officer);
		return officer;
	}

	/*
	 * it checks whether the ofiicer's credential is valid or not
	 * it returns true or false
	 */
	@Override
	public Boolean isValidFinanceOfficer(String username, String password) {
		return iFinanceVerificationRepository.findByUsernameAndPassword(username, password)!=null;
	}
	
}