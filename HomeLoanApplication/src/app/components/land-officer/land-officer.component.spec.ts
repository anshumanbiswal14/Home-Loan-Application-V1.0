import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandOfficerComponent } from './land-officer.component';

describe('LandOfficerComponent', () => {
  let component: LandOfficerComponent;
  let fixture: ComponentFixture<LandOfficerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandOfficerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LandOfficerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
