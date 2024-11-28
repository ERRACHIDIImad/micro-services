import { TestBed } from '@angular/core/testing';

import { CommercialDivisionService } from './commercial-division.service';

describe('CommercialDivisionService', () => {
  let service: CommercialDivisionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommercialDivisionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
