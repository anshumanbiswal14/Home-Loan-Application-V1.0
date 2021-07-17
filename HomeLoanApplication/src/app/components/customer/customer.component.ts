import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerName!: string;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    let userName = localStorage.getItem('username');
    let id: number;
    if (userName != null) {
      this.customerService.getUserId(userName).subscribe(result => {
        id = result;
        this.customerService.getCustomer(id).subscribe(customer => this.customerName = customer.customerName);
      });
    }
  }
}
