import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersListComponentComponent } from './customers-list-component.component';

describe('CustomersListComponentComponent', () => {
  let component: CustomersListComponentComponent;
  let fixture: ComponentFixture<CustomersListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomersListComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomersListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
