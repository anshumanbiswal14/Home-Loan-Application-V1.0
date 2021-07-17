import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanAgreementComponent } from './loan-agreement.component';

describe('LoanAgreementComponent', () => {
  let component: LoanAgreementComponent;
  let fixture: ComponentFixture<LoanAgreementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanAgreementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanAgreementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
