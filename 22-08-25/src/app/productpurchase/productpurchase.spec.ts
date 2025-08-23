import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Productpurchase } from './productpurchase';

describe('Productpurchase', () => {
  let component: Productpurchase;
  let fixture: ComponentFixture<Productpurchase>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Productpurchase]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Productpurchase);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
