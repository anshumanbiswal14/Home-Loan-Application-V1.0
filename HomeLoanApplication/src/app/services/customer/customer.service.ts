import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Customer } from 'src/app/models/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  url: string = 'http://localhost:8095/homeloan/customer';

  constructor(private http: HttpClient) {
  }

  // customerLogin(username: string, password: string): Observable<any> {
  //   return this.http.get(`${this.url}/validatingCustomer/${username}/${password}`);
  // }

  addCustomer(customer: Customer): Observable<any> {
    return this.http.post(`${this.url}/addCustomer`, customer);
  }

  getUserId(userName: string): Observable<any> {
    return this.http.get(`${this.url}/getUserId/${userName}`);
  }

  getCustomer(userId:number):Observable<any>{
    return this.http.get(`${this.url}/getCustomer/${userId}`)
  }

  applyLoan(userId: number, loanAppliedAmount: number, loanTenureYears: number): Observable<any> {
    return this.http.post(`${this.url}/applyLoan/${userId}/${loanAppliedAmount}/${loanTenureYears}`, userId);
  }

  loanTracker(loanApplicationId: number):Observable<any>{
    return this.http.get(`${this.url}/loanTracker/${loanApplicationId}`);
  }
  
   getLoanAgreement(loanApplicationId:number):Observable<any>{
     return this.http.get(`${this.url}/loanAgreement/${loanApplicationId}`)
   }

  customerLogin(credentials : any): Observable<any> {
    return this.http.post(`${this.url}/login`,credentials);
  }
}
