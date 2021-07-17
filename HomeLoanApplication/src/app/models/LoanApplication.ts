import { Customer } from "./Customer";

export class LoanApplication{
    applicationId!: number;
	applicationDate!: string;  
	customer!: Customer;
	loanAppliedAmount!: number;
	loanTenureYears!: number;
	loanApprovedAmount!: number;
	landVerificationApproval!: boolean;
	financeVerificationApproval!: boolean;
	adminApproval!: boolean;
}