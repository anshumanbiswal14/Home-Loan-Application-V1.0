import { TestBed } from '@angular/core/testing';

import { CustomerAuthGuard } from './customer-auth.guard';

describe('CustomerAuthGuard', () => {
  let guard: CustomerAuthGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CustomerAuthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
