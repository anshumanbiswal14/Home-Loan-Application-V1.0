import { Component, OnInit } from '@angular/core';
import { LandOfficerService } from 'src/app/services/land-officer/land-officer.service';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-land-officer-login',
  templateUrl: './land-officer-login.component.html',
  styleUrls: ['./land-officer-login.component.css']
})
export class LandOfficerLoginComponent implements OnInit {
  credential ={
    username : '',
    password : ''
  }

  constructor(private landOfficerService: LandOfficerService, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  save(): void {
    this.landOfficerService.landOfficerLogin(this.credential).subscribe(
      result => {
          console.log("Result: ",result.token);
          this.loginService.loginLandOfficer(result.token);
          localStorage.setItem('username', this.credential.username);
          window.location.href = "/landOfficer";
      },
      error=>{
        alert("Invalid Credintails !!!! \nPlease Enter correct UserName and Password");
        console.log('error: ',error);
        window.location.href="/landOfficerLogin";
      }
    )
  }

}
