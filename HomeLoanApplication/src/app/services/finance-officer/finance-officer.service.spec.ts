import { TestBed } from '@angular/core/testing';

import { FinanceOfficerService } from './finance-officer.service';

describe('FinanceOfficerService', () => {
  let service: FinanceOfficerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FinanceOfficerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
