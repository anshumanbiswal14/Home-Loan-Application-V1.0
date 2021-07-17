import { Component, OnInit } from '@angular/core';
import { LoanApplication } from 'src/app/models/LoanApplication';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-loan-apply',
  templateUrl: './loan-apply.component.html',
  styleUrls: ['./loan-apply.component.css']
})
export class LoanApplyComponent implements OnInit {

  loanApplication = new LoanApplication();

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
  }

  save(): void {
    const username =localStorage.getItem('username');
    
    if(username!=null){
      this.customerService.getUserId(username).subscribe(
        userId=>{
          if(userId)
            this.customerService.applyLoan(userId,this.loanApplication.loanAppliedAmount,this.loanApplication.loanTenureYears).subscribe(
              result=>{
                alert(`Loan Applied Succesfully \n This is your Application Id : ${result.applicationId} \n please remember this Application Id !!!`)
                window.location.href="/customer";
              },
              error=>console.log('error: ',error)
            );
        },
        error => console.log('error: ', error)
      )
    }

  }
}
