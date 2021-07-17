import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmiService {

  private baseURL = 'http://localhost:8095/homeloan/customer/EMICalculator/';

  constructor(private http: HttpClient) { }


  calculateEmi(emi:number,interestRate: number,time: number): Observable<any> {

    return this.http.get(`http://localhost:8095/homeloan/customer/EMICalculator/${emi}/${interestRate}/${time}`);
  }
}

