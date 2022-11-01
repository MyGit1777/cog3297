import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { LoginuserService } from '../loginuser.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public loggedIn=false;
  user:any;

  constructor(private loginservice: LoginuserService) { }
  ngOnInit(): void {

    this.loggedIn=this.loginservice.isLoggedIn();
    this.user= localStorage.getItem("user");
console.log("this is dash" + this.user);
  }
  logoutUser(){

    this.loginservice.logoutUser();
     window.location.href="/home";

    // location.reload();
  }
}
