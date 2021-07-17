package com.cg.homeloan.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.homeloan.entities.LoanAgreement;

public interface ILoanAgreementRepository extends JpaRepository<LoanAgreement, Integer> {
	
	public Optional<LoanAgreement> findByLoanApplicationId(int loanApplicationId);
}
