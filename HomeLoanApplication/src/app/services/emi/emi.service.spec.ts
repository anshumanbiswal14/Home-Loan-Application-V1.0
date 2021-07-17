import { TestBed } from '@angular/core/testing';

import { EmiService } from './emi.service';

describe('EmiService', () => {
  let service: EmiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
