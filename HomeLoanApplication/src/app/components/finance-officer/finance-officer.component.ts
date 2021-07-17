import { Component, OnInit } from '@angular/core';
import { LoanApplication } from 'src/app/models/LoanApplication';
import { FinanceOfficerService } from 'src/app/services/finance-officer/finance-officer.service';

@Component({
  selector: 'app-finance-officer',
  templateUrl: './finance-officer.component.html',
  styleUrls: ['./finance-officer.component.css']
})
export class FinanceOfficerComponent implements OnInit {

  loanApplication = new LoanApplication();
  constructor(private financeOfficerService: FinanceOfficerService) { }

  ngOnInit(): void {
    this.financeOfficerService.getLoanApplicationList().subscribe(
      result => {
        this.loanApplicationList = result
        console.log(this.loanApplication)
      });
  }

  loanApplicationList: LoanApplication[] = [];

  getList(): void {
    this.financeOfficerService.getLoanApplicationList().subscribe(
      result => {
        this.loanApplicationList = result
        console.log(this.loanApplication)
      });
  }
  
  updateList(id:number): void {
    this.financeOfficerService.updateStatus(id,id).subscribe(
      result => {
        alert("Update Sucessfully!!!")
        this.getList()
      });

  }

}
