import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCommercialDivisionComponent } from './update-commercial-division.component';

describe('UpdateCommercialDivisionComponent', () => {
  let component: UpdateCommercialDivisionComponent;
  let fixture: ComponentFixture<UpdateCommercialDivisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateCommercialDivisionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateCommercialDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
