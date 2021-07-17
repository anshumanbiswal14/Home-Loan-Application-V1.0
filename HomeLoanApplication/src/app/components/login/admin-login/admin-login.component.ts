import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  credential ={
    username : '',
    password : ''
  }

  constructor(private adminService: AdminService,private loginService: LoginService) { }

  ngOnInit(): void {
  }

  save():void {
    this.adminService.adminLogin(this.credential).subscribe(
      result=>{
          console.log("Result: ",result.token);
          this.loginService.loginAdmin(result.token);
          localStorage.setItem('username',this.credential.username);
          window.location.href="/admin";
      },
      error=>{
        alert("Invalid Credintails !!!! \nPlease Enter correct UserName and Password");
        console.log('error: ',error);
        window.location.href="/adminLogin";
      }
    )
  }

}
