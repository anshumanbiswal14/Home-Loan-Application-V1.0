import { TestBed } from '@angular/core/testing';

import { LandOfficerService } from './land-officer.service';

describe('LandOfficerService', () => {
  let service: LandOfficerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LandOfficerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
