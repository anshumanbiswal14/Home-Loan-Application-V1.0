import { Component, OnInit } from '@angular/core';
import {  NgForm } from '@angular/forms';
import { Customer } from 'src/app/models/Customer';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

   customer=new Customer();

  constructor(private customerService: CustomerService) { 
    }

  ngOnInit(): void {
  }
 
  save(customerForm: NgForm): void {
    console.log("details :" + this.customer.customerName);
    this.customerService.addCustomer(this.customer).subscribe(
      result => {
        console.log('Success: ',result)
        alert("Register Succefully !!! ")
        window.location.href="/login"
      },
      error => {
        console.log('error: ',error)
      }
    );
  }
}
