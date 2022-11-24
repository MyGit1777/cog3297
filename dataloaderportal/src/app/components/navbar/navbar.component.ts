import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public loggedIn = false;
  constructor(private loginservice: LoginServiceService, private router: Router) { }

  ngOnInit(): void {    
    this.loggedIn=this.loginservice.isLoggedIn();
  }

  logoutUser(){

    this.loginservice.logoutUser();
    window.location.href="/home";
    // window.location.reload();
  }

}
