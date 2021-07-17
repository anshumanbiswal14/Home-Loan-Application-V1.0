import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerLoginComponent } from './customer-login.component';

describe('CustomerLoginComponent', () => {
  let component: CustomerLoginComponent;
  let fixture: ComponentFixture<CustomerLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
