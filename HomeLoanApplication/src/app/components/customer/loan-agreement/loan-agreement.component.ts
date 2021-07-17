import { Component, OnInit } from '@angular/core';
import { LoanAgreement } from 'src/app/models/LoanAgreement';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-loan-agreement',
  templateUrl: './loan-agreement.component.html',
  styleUrls: ['./loan-agreement.component.css']
})
export class LoanAgreementComponent implements OnInit {
  loanAgreement = new LoanAgreement();
  loanApplicationId!: number;
  status: boolean = false;
  agreementStatus: boolean = false;
  loanStatus!: string;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
  }

  getLoanAgreement() {
    if (this.loanApplicationId != null) {
      this.customerService.loanTracker(this.loanApplicationId).subscribe(
        result => {
          this.loanStatus = result;
          console.log(result);
          if (this.loanStatus.localeCompare('APPROVED'))
            this.status = true;
          else {
            this.customerService.getLoanAgreement(this.loanApplicationId).subscribe(
              agreement => {
                this.loanAgreement = agreement;
                this.agreementStatus = true;
              },
              error => console.error('error: ', error)
            )
          }
        },
        error => {console.error('error: ', error)
        if(error.status==404)
          alert("Please enter a valid Application Id");
        }
      )
    }
    else {
      alert("Please enter Loan Application Id !!!")
    }

  }
}
