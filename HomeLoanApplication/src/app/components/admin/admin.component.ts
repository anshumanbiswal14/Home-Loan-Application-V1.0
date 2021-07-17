import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/models/Admin';
import { Customer } from 'src/app/models/Customer';
import { FinanceVerificationOfficer } from 'src/app/models/FinanceOfficer';
import { LandVerificationOfficer } from 'src/app/models/LandOfficer';
import { LoanApplication } from 'src/app/models/LoanApplication';
import { AdminService } from 'src/app/services/admin/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  showList: boolean = false;
  showCustomer: boolean = false;
  showAdmin = false;
  landOfficer = new LandVerificationOfficer();
  financeOfficer = new FinanceVerificationOfficer();
  admin = new Admin();


  constructor(private adminService: AdminService) { }

  loanApplicationList: LoanApplication[] = [];
  customerList: Customer[] = [];
  adminList: Admin[] = [];



  getList(): void {
    this.adminService.getLoanApplicationList().subscribe(
      result => {
        this.loanApplicationList = result
      });
  }
  getCustomer(): void {
    this.adminService.getCustomerList().subscribe(
      result => {
        this.customerList = result
      });
  }

  toggleList(): void {
    this.showList = !this.showList;
  }
  toggleCustomer(): void {
    this.showCustomer = !this.showCustomer;
  }
  toggleAdmin(): void {
    this.showAdmin = !this.showAdmin;
  }
  updateList(id: number): void {
    this.adminService.updateStatus(id, id).subscribe(
      result => {
        alert("Update Sucessfully!!!")
        this.getList()
      });
  }
  viewAllAdmin(): void {
    this.adminService.viewAllAdmin().subscribe(
      result => {
        this.adminList = result;
      }
    );
  }

  deleteCustomer(id: number): void {
    confirm("Please confirm to delete the customer !!!");
    this.adminService.deleteCustomer(id).subscribe(
      result => {
        alert("Customer Deleted");
        this.getCustomer();
      },
      error =>{
        alert(error);
        this.getCustomer();
      }
    )
  }
  addlandclick() {
    this.adminService.addLandOfficerDetail(this.landOfficer).subscribe(
      result => {
        alert("Land Officer Details Added");
        window.location.href = "/admin";
      },
    );
  }
  addfinclick() {
    this.adminService.addFinanceOfficerDetail(this.financeOfficer).subscribe(
      result => {
        alert("Finance Officer Details Added");
        window.location.href = "/admin";
      }
    );
  }

  addAdmin() {
    this.adminService.addAdmin(this.admin).subscribe(
      result => {
        alert("Admin Added");
        window.location.href = "/admin";
      }
    );
  }

  ngOnInit(): void {
  }
}

