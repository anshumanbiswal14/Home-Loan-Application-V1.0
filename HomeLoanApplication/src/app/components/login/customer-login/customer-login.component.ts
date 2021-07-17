import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer/customer.service';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {
  credential ={
    username : '',
    password : ''
  }

  constructor(private customerService: CustomerService, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  save():void {
    this.customerService.customerLogin(this.credential).subscribe(
      result=>{
          this.loginService.loginCustomer(result.token);
          localStorage.setItem('username',this.credential.username);
          window.location.href="/customer/home";
      },
      error=>{
        alert("Invalid Credintails !!!! \nPlease Enter correct UserName and Password");
        console.log('error: ',error);
        window.location.href="/customerLogin";
      }
    )
  }

}
