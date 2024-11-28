import { ComponentFixture, TestBed } from '@angular/core/testing';

// @ts-ignore
import { UpdateMarketComponent } from './update-market.component';

describe('UpdateMarketComponent', () => {
  let component: UpdateMarketComponent;
  let fixture: ComponentFixture<UpdateMarketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateMarketComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateMarketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
