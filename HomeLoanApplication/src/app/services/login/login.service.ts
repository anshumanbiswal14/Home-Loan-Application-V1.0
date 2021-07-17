import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }

  loginCustomer(token : string) {
    localStorage.setItem('login', 'customer');
    localStorage.setItem('token',token);
  }

  loginAdmin(token:string) {
    localStorage.setItem('login', 'admin');
    localStorage.setItem('token',token);
  }

  loginFinanceOfficer(token: string) {
    localStorage.setItem('login', 'financeOfficer');
    localStorage.setItem('token',token);
  }

  loginLandOfficer(token:string) {
    localStorage.setItem('login', 'landOfficer');
    localStorage.setItem('token',token);
  }

  isCustomerLoggedIn(): boolean {
    if (localStorage.getItem('login') == 'customer')
      return true;
    else
      return false;
  }

  isAdminLoggedIn(): boolean {
    if (localStorage.getItem('login') == 'admin')
      return true;
    else
      return false;
  }

  isFinanceOfficerLoggedIn(): boolean {
    if (localStorage.getItem('login') == 'financeOfficer')
      return true;
    else
      return false;
  }

  isLandOfficerLoggedIn(): boolean {
    if (localStorage.getItem('login') == 'landOfficer')
      return true;
    else
      return false;
  }

  logout() {
    localStorage.removeItem('login')
    localStorage.removeItem('username');
    localStorage.removeItem('token');
  }

  getToken(){
    return localStorage.getItem("token");
  }

}
