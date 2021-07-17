import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-loan-tracker',
  templateUrl: './loan-tracker.component.html',
  styleUrls: ['./loan-tracker.component.css']
})
export class LoanTrackerComponent implements OnInit {

  status!: string;
  loanApplicationId!: number;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
  }

  getStatus() {
    if (this.loanApplicationId != null) {
      this.customerService.loanTracker(this.loanApplicationId).subscribe(
        result => this.status=result,
        error => console.log('error: ', error)
      );
    }
    else{
      alert("Please enter Loan Application Id first !!!")
    }
  }

}
