package com.cg.homeloan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan_agreement")
public class LoanAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanAgreementId;

	@Column
	private int loanApplicationId;

	@OneToOne
	private EMI emi;

	public LoanAgreement() {
		super();
	}

	public LoanAgreement(int loanAgreementId, int loanApplicationId, EMI emi) {
		super();
		this.loanAgreementId = loanAgreementId;
		this.loanApplicationId = loanApplicationId;
		this.emi = emi;
	}
	
	public LoanAgreement(int loanApplicationId, EMI emi) {
		super();
		this.loanApplicationId = loanApplicationId;
		this.emi = emi;
	}

	public int getLoanAgreementId() {
		return loanAgreementId;
	}

	public void setLoanAgreementId(int loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}

	public int getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(int loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public EMI getEmi() {
		return emi;
	}

	public void setEmi(EMI emi) {
		this.emi = emi;
	}

	@Override
	public String toString() {
		return "LoanAgreement [loanAgreementId=" + loanAgreementId + ", loanApplicationId=" + loanApplicationId
				+ ", emi=" + emi + "]";
	}

}
