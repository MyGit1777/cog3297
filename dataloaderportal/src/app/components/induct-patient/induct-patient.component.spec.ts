import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InductPatientComponent } from './induct-patient.component';

describe('InductPatientComponent', () => {
  let component: InductPatientComponent;
  let fixture: ComponentFixture<InductPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InductPatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InductPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
