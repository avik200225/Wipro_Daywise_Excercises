import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex4 } from './ex4';

describe('Ex4', () => {
  let component: Ex4;
  let fixture: ComponentFixture<Ex4>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex4]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex4);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
