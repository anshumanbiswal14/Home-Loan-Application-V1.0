import { TestBed } from '@angular/core/testing';

import { LandOfficerAuthGuard } from './land-officer-auth.guard';

describe('LandOfficerAuthGuard', () => {
  let guard: LandOfficerAuthGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LandOfficerAuthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
