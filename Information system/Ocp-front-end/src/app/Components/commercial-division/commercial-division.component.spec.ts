import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommercialDivisionComponent } from './commercial-division.component';

describe('CommercialDivisionComponent', () => {
  let component: CommercialDivisionComponent;
  let fixture: ComponentFixture<CommercialDivisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CommercialDivisionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CommercialDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
