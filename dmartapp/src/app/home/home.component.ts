import { Component, OnInit } from '@angular/core';
import { LoginuserService } from '../loginuser.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public loggedIn=false;
  user:any;

  constructor(private loginservice: LoginuserService) { }
  ngOnInit(): void {

    this.loggedIn=this.loginservice.isLoggedIn();
    this.user= localStorage.getItem("user");
    console.log("this is dash" + this.user);
  }
}
