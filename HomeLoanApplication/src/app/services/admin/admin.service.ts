import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from 'src/app/models/Admin';
import { FinanceVerificationOfficer } from 'src/app/models/FinanceOfficer';
import { LandVerificationOfficer } from 'src/app/models/LandOfficer';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url: string = 'http://localhost:8095/homeloan/admin';
  private baseURL = 'http://localhost:8095/homeloan/admin/LoanApplications';
  private updateURL = 'http://localhost:8095/homeloan/admin/updateAdminVerificationStatus/';
  private deleteURL = "http://localhost:8095/homeloan/admin/deleteCustomer/";
  private addLandURL = "http://localhost:8095/homeloan/admin/addLandOfficer";
  private addFinanceURL = "http://localhost:8095/homeloan/admin/addFinanceOfficer";
  private addAdminURL = "http://localhost:8095/homeloan/admin/addAdmin";
  private viewAllAdminURL = "http://localhost:8095/homeloan/admin/Admins";
  private allCustURL = 'http://localhost:8095/homeloan/admin/customers';

  constructor(private http: HttpClient) { }

  // adminLogin(username: string, password: string): Observable<any> {
  //   return this.http.get(`${this.url}/validatingAdmin/${username}/${password}`);
  // }

  getLoanApplicationList(): Observable<any> {
    return this.http.get(this.baseURL);
  }
  updateStatus(id: number, value: any): Observable<any> {
    return this.http.put(`${this.updateURL}${id}`, value);
  }
  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.deleteURL}${id}`);
  }
  addLandOfficerDetail(landOfficer: LandVerificationOfficer): Observable<any> {
    return this.http.post(`${this.addLandURL}`, landOfficer);
  }
  addFinanceOfficerDetail(financeOfficer: FinanceVerificationOfficer): Observable<any> {
    return this.http.post(`${this.addFinanceURL}`, financeOfficer);
  }
  addAdmin(admin:Admin): Observable<any> {
    return this.http.post(`${this.addAdminURL}`,admin)
  }
  viewAllAdmin(): Observable<any> {
    return this.http.get(`${this.viewAllAdminURL}`)
  }
   getCustomerList(): Observable<any> {
    return this.http.get(this.allCustURL);
  }

  adminLogin(credentials : any): Observable<any> {
    return this.http.post(`${this.url}/login`,credentials);
  }


}
