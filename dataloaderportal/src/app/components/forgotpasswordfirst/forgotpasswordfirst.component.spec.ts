import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotpasswordfirstComponent } from './forgotpasswordfirst.component';

describe('ForgotpasswordfirstComponent', () => {
  let component: ForgotpasswordfirstComponent;
  let fixture: ComponentFixture<ForgotpasswordfirstComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ForgotpasswordfirstComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ForgotpasswordfirstComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
