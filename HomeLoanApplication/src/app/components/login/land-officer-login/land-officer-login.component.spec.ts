import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandOfficerLoginComponent } from './land-officer-login.component';

describe('LandOfficerLoginComponent', () => {
  let component: LandOfficerLoginComponent;
  let fixture: ComponentFixture<LandOfficerLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandOfficerLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LandOfficerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
