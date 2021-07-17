import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FinanceOfficerService {
  url: string = 'http://localhost:8095/homeloan/financeOfficer';
  private baseURL = 'http://localhost:8095/homeloan/financeOfficer/LoanApplications';
  private updateURL = 'http://localhost:8095/homeloan/financeOfficer/updateFinanceVerificationStatus/';

  constructor(private http: HttpClient) { }

  // financeOfficerLogin(username: string, password: string): Observable<any> {
  //   return this.http.get(`${this.url}/validatingFinanceOfficer/${username}/${password}`);
  // }

  getLoanApplicationList(): Observable<any> {
    return this.http.get(this.baseURL);
  }
  updateStatus(id: number,value: any): Observable<any> {
    return this.http.put(`${this.updateURL}${id}`,value);
  }

  financeOfficerLogin(credentials : any): Observable<any> {
    return this.http.post(`${this.url}/login`,credentials);
  }

}
