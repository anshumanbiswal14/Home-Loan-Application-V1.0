package com.cg.homeloan.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan_application")
public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applicationId;
	@Column
	private LocalDate applicationDate;  
	@OneToOne
	private Customer customer;
	@Column
	private double loanAppliedAmount;
	@Column
	private int loanTenureYears;
	@Column
	private double loanApprovedAmount;
	@Column
	private boolean landVerificationApproval;
	@Column
	private boolean financeVerificationApproval;
	@Column
	private boolean adminApproval;
	@Column
	@Enumerated(EnumType.STRING)
	private Status status;

	public LoanApplication() {
		super();
	}
	
	public LoanApplication(int applicationId, LocalDate applicationDate, Customer customer, double loanAppliedAmount,
			int loanTenureYears, double loanApprovedAmount, boolean landVerificationApproval,
			boolean financeVerificationApproval, boolean adminApproval, Status status) {
		super();
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanTenureYears = loanTenureYears;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}



	public LoanApplication(Customer customer, double loanAppliedAmount, int loanTenureYears) {
		super();
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.applicationDate=LocalDate.now();
		this.loanTenureYears=loanTenureYears;
		this.landVerificationApproval = false;
		this.financeVerificationApproval = false;
		this.adminApproval=false;
		this.status = Status.WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public int getLoanTenureYears() {
		return loanTenureYears;
	}

	public void setLoanTenureYears(int loanTenureYears) {
		this.loanTenureYears = loanTenureYears;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public boolean isFinanceVerificationApproval() {
		return financeVerificationApproval;
	}

	public void setFinanceVerificationApproval(boolean financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}

	public boolean isAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", applicationDate=" + applicationDate
				+ ", customer=" + customer + ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount="
				+ loanApprovedAmount + ", landVerificationApproval=" + landVerificationApproval
				+ ", financeVerificationApproval=" + financeVerificationApproval + ", adminApproval=" + adminApproval
				+ ", status=" + status + "]";
	}

}
