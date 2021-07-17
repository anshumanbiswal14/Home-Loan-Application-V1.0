import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanTrackerComponent } from './loan-tracker.component';

describe('LoanTrackerComponent', () => {
  let component: LoanTrackerComponent;
  let fixture: ComponentFixture<LoanTrackerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanTrackerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanTrackerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
