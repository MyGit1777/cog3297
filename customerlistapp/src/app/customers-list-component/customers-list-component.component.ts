import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-customers-list-component',
  templateUrl: './customers-list-component.component.html',
  styleUrls: ['./customers-list-component.component.css']
})
export class CustomersListComponentComponent implements OnInit {

  name = '';
  customers: string[] = [];

  constructor() { }
   ngOnInit() {
  }

  public onAddCustomer(name: any) {

  this.customers.push(this.name);
   this.name = '';

  }

}
