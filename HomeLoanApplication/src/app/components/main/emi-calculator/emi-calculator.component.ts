import { Component, OnInit } from '@angular/core';
import { EmiService } from 'src/app/services/emi/emi.service';

@Component({
  selector: 'app-emi-calculator',
  templateUrl: './emi-calculator.component.html',
  styleUrls: ['./emi-calculator.component.css']
})
export class EmiCalculatorComponent implements OnInit {
  constructor(private emiservice: EmiService) { }



  principal!: number;
  rate!: number;
  time!: number;
  emi!: number;
  amt!: number;
  status=false;



  calculateEmi(): void {
    this.emiservice.calculateEmi(this.principal, this.rate, this.time).subscribe(
      result => {
        this.emi = result;
        this.amt = result *  this.time * 12;
        this.status=true;
        }
    );
  }

  ngOnInit(): void {
  }

}
