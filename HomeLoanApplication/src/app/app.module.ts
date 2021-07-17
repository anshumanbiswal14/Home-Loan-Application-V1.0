import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/main/home/home.component';
import { HeaderComponent } from './components/main/header/header.component';
import { FooterComponent } from './components/main/footer/footer.component';
import { AboutUsComponent } from './components/main/about-us/about-us.component';
import { ContactUsComponent } from './components/main/contact-us/contact-us.component';
import { CustomerComponent } from './components/customer/customer.component';
import { LoanApplyComponent } from './components/customer/loan-apply/loan-apply.component';
import { LoanTrackerComponent } from './components/customer/loan-tracker/loan-tracker.component';
import { LoanAgreementComponent } from './components/customer/loan-agreement/loan-agreement.component';
import { AdminComponent } from './components/admin/admin.component';
import { LandOfficerComponent } from './components/land-officer/land-officer.component';
import { FinanceOfficerComponent } from './components/finance-officer/finance-officer.component';
import { RegisterComponent } from './components/main/register/register.component';
import { EmiCalculatorComponent } from './components/main/emi-calculator/emi-calculator.component';
import { CustomerLoginComponent } from './components/login/customer-login/customer-login.component';
import { AdminLoginComponent } from './components/login/admin-login/admin-login.component';
import { LandOfficerLoginComponent } from './components/login/land-officer-login/land-officer-login.component';
import { FinanceOfficerLoginComponent } from './components/login/finance-officer-login/finance-officer-login.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AuthInterceptor } from './interceptor/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    AboutUsComponent,
    ContactUsComponent,
    CustomerComponent,
    LoanApplyComponent,
    LoanTrackerComponent,
    LoanAgreementComponent,
    AdminComponent,
    LandOfficerComponent,
    FinanceOfficerComponent,
    RegisterComponent,
    EmiCalculatorComponent,
    CustomerLoginComponent,
    AdminLoginComponent,
    LandOfficerLoginComponent,
    FinanceOfficerLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: 
  [
    [{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true}]
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
