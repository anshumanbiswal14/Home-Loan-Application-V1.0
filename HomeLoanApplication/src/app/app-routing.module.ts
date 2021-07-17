import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { CustomerComponent } from './components/customer/customer.component';
import { LoanAgreementComponent } from './components/customer/loan-agreement/loan-agreement.component';
import { LoanApplyComponent } from './components/customer/loan-apply/loan-apply.component';
import { LoanTrackerComponent } from './components/customer/loan-tracker/loan-tracker.component';
import { FinanceOfficerComponent } from './components/finance-officer/finance-officer.component';
import { LandOfficerComponent } from './components/land-officer/land-officer.component';
import { AdminLoginComponent } from './components/login/admin-login/admin-login.component';
import { CustomerLoginComponent } from './components/login/customer-login/customer-login.component';
import { FinanceOfficerLoginComponent } from './components/login/finance-officer-login/finance-officer-login.component';
import { LandOfficerLoginComponent } from './components/login/land-officer-login/land-officer-login.component';
import { AboutUsComponent } from './components/main/about-us/about-us.component';
import { ContactUsComponent } from './components/main/contact-us/contact-us.component';
import { EmiCalculatorComponent } from './components/main/emi-calculator/emi-calculator.component';
import { HomeComponent } from './components/main/home/home.component';
import { RegisterComponent } from './components/main/register/register.component';
import { AdminAuthGuard } from './guards/admin-auth.guard';
import { CustomerAuthGuard } from './guards/customer-auth.guard';
import { FinanceOfficerAuthGuard } from './guards/finance-officer-auth.guard';
import { LandOfficerAuthGuard } from './guards/land-officer-auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'register', component: RegisterComponent },
  { path: 'aboutUs', component: AboutUsComponent},
  { path: 'contactUs', component: ContactUsComponent},
  { path: 'emiCalculator',component: EmiCalculatorComponent},
  { path: 'adminLogin', component: AdminLoginComponent},
  { path: 'customerLogin', component: CustomerLoginComponent},
  { path: 'financeOfficerLogin', component: FinanceOfficerLoginComponent},
  { path: 'landOfficerLogin', component: LandOfficerLoginComponent},
  { path: 'customer/home', component:CustomerComponent, canActivate: [CustomerAuthGuard]},
  { path: 'customer', redirectTo: 'customer/home', pathMatch: 'full'},
  { path: 'customer/loanApply',component: LoanApplyComponent, canActivate: [CustomerAuthGuard]},
  { path: 'customer/loanTrack', component: LoanTrackerComponent, canActivate: [CustomerAuthGuard]},
  { path: 'customer/loanAgreement', component: LoanAgreementComponent, canActivate: [CustomerAuthGuard]},
  { path: 'admin', component: AdminComponent, canActivate: [AdminAuthGuard]},
  { path: 'financeOfficer', component: FinanceOfficerComponent, canActivate: [FinanceOfficerAuthGuard]},
  { path: 'landOfficer', component: LandOfficerComponent, canActivate: [LandOfficerAuthGuard]},

  { path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
