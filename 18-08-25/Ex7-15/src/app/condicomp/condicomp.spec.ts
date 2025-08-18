import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Condicomp } from './condicomp';

describe('Condicomp', () => {
  let component: Condicomp;
  let fixture: ComponentFixture<Condicomp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Condicomp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Condicomp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
