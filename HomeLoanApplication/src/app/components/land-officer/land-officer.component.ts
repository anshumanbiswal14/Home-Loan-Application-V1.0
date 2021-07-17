import { Component, OnInit } from '@angular/core';
import { LoanApplication } from 'src/app/models/LoanApplication';
import { LandOfficerService } from 'src/app/services/land-officer/land-officer.service';

@Component({
  selector: 'app-land-officer',
  templateUrl: './land-officer.component.html',
  styleUrls: ['./land-officer.component.css']
})
export class LandOfficerComponent implements OnInit {

  loanApplication = new LoanApplication();
  constructor(private landOfficerService: LandOfficerService) { }


  ngOnInit(): void {
    this.landOfficerService.getLoanApplicationList().subscribe(
      result => {
        this.loanApplicationList = result
        console.log(this.loanApplication)
      });
     

  }


  loanApplicationList: LoanApplication[] = [];
  num !: number;
  getList(): void {
    this.landOfficerService.getLoanApplicationList().subscribe(
      result => {
        this.loanApplicationList = result
        console.log(this.loanApplication)
      });

  }
  updateList(id: number): void {
    this.landOfficerService.updateStatus(id, id).subscribe(
      result => {
        alert("Update Sucessfully!!!")
        this.getList();
      })
 

  }

}