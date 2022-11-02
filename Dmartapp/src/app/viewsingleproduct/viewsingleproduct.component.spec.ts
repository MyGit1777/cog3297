import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewsingleproductComponent } from './viewsingleproduct.component';

describe('ViewsingleproductComponent', () => {
  let component: ViewsingleproductComponent;
  let fixture: ComponentFixture<ViewsingleproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewsingleproductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewsingleproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
