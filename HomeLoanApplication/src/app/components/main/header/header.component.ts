import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLoggedIn:boolean=false;
  isCustomerLoggedIn=false;
  isAdminLoggedIn=false;
  isLandOfficerLoggedIn=false;
  isFinanceOfficerLoggedIn=false;

  constructor(private loginService: LoginService,private router:Router) { }

  ngOnInit(): void {
    let ch=localStorage.getItem('login');
    if(ch!=null){
      switch(ch){
        case "admin":{
          this.isLoggedIn=true;
          this.isAdminLoggedIn=true;
          break;
        }
        case "customer":{
          this.isLoggedIn=true;
          this.isCustomerLoggedIn=true;
          break;
        }
        case "landOfficer":{
          this.isLoggedIn=true;
          this.isLandOfficerLoggedIn=true;
          break;
        }
        case "financeOfficer":{
          this.isLoggedIn=true;
          this.isFinanceOfficerLoggedIn=true;
          break;
        }
        default :{
          this.isLoggedIn=false;
          break;
        }
      }
    }
  }

  logout(){
    
    this.loginService.logout();
    this.isLoggedIn=false;
    this.isAdminLoggedIn=false;
    this.isCustomerLoggedIn=false;
    this.isLandOfficerLoggedIn=false;
    this.isFinanceOfficerLoggedIn=false;
    this.router.navigate(['']);
    
  }
}
