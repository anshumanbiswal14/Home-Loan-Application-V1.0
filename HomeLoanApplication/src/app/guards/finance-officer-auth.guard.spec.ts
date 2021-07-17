import { TestBed } from '@angular/core/testing';

import { FinanceOfficerAuthGuard } from './finance-officer-auth.guard';

describe('FinanceOfficerAuthGuard', () => {
  let guard: FinanceOfficerAuthGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(FinanceOfficerAuthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
