import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCommercialDivisionComponent } from './add-commercial-division.component';

describe('AddCommercialDivisionComponent', () => {
  let component: AddCommercialDivisionComponent;
  let fixture: ComponentFixture<AddCommercialDivisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddCommercialDivisionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddCommercialDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
