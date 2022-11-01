import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  public loggedIn=false;
  constructor(private loginservice: LoginserviceService) { }

  ngOnInit(): void {

    this.loggedIn=this.loginservice.isLoggedIn()
  }
  logoutUser(){

    this.loginservice.logoutUser();
    location.reload();
  }
}
