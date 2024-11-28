import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndustrialDivisionComponent } from './industrial-division.component';

describe('IndustrialDivisionComponent', () => {
  let component: IndustrialDivisionComponent;
  let fixture: ComponentFixture<IndustrialDivisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IndustrialDivisionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IndustrialDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
