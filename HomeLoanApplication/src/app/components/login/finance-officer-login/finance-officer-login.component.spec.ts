import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceOfficerLoginComponent } from './finance-officer-login.component';

describe('FinanceOfficerLoginComponent', () => {
  let component: FinanceOfficerLoginComponent;
  let fixture: ComponentFixture<FinanceOfficerLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FinanceOfficerLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceOfficerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
