import { TestBed } from '@angular/core/testing';

import { IndustrialDivisionService } from './industrial-division.service';

describe('IndustrialDivisionService', () => {
  let service: IndustrialDivisionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IndustrialDivisionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
