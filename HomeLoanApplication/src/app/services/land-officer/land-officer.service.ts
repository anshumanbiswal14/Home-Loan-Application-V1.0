import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LandOfficerService {
  url: string = 'http://localhost:8095/homeloan/landOfficer';
  private baseURL = 'http://localhost:8095/homeloan/landOfficer/LoanApplications';
  private updateURL = 'http://localhost:8095/homeloan/landOfficer/updateLandVerificationStatus/';

  constructor(private http: HttpClient) { }

  // return this.httpClient.get(`${this.empApi}${id}`);
  // landOfficerLogin(username: string, password: string): Observable<any> {
  //   return this.http.get(`${this.url}/validatingLandOfficer/${username}/${password}`);
  // }

  getLoanApplicationList(): Observable<any> {
    return this.http.get(this.baseURL);
  }

  updateStatus(id: number,value: any): Observable<any> {
    return this.http.put(`${this.updateURL}${id}`,value);
  }

  landOfficerLogin(credentials : any): Observable<any> {
    return this.http.post(`${this.url}/login`,credentials);
  }
}