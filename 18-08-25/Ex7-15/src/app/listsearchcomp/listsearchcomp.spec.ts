import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Listsearchcomp } from './listsearchcomp';

describe('Listsearchcomp', () => {
  let component: Listsearchcomp;
  let fixture: ComponentFixture<Listsearchcomp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Listsearchcomp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Listsearchcomp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
