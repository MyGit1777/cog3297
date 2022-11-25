import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotpasswordsecondComponent } from './forgotpasswordsecond.component';

describe('ForgotpasswordsecondComponent', () => {
  let component: ForgotpasswordsecondComponent;
  let fixture: ComponentFixture<ForgotpasswordsecondComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ForgotpasswordsecondComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ForgotpasswordsecondComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
