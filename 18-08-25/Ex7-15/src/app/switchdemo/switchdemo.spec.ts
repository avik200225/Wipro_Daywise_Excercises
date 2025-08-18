import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Switchdemo } from './switchdemo';

describe('Switchdemo', () => {
  let component: Switchdemo;
  let fixture: ComponentFixture<Switchdemo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Switchdemo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Switchdemo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
