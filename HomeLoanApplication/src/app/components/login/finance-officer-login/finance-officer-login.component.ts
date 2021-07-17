import { Component, OnInit } from '@angular/core';
import { FinanceOfficerService } from 'src/app/services/finance-officer/finance-officer.service';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-finance-officer-login',
  templateUrl: './finance-officer-login.component.html',
  styleUrls: ['./finance-officer-login.component.css']
})
export class FinanceOfficerLoginComponent implements OnInit {
  credential ={
    username : '',
    password : ''
  }


  constructor(private financeOfficerServic: FinanceOfficerService, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  save():void {
    this.financeOfficerServic.financeOfficerLogin(this.credential).subscribe(
      result=>{
          this.loginService.loginFinanceOfficer(result.token);
          localStorage.setItem('username',this.credential.username);
          window.location.href="/financeOfficer";
      },
      error=>{
        alert("Invalid Credintails !!!! \nPlease Enter correct UserName and Password");
        console.log('error: ',error);
        window.location.href="/financeOfficerLogin";
      }
    )
  }

}
