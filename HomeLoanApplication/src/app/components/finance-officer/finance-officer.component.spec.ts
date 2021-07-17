import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceOfficerComponent } from './finance-officer.component';

describe('FinanceOfficerComponent', () => {
  let component: FinanceOfficerComponent;
  let fixture: ComponentFixture<FinanceOfficerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FinanceOfficerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceOfficerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
