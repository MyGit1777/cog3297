import { Component, Injectable, OnInit } from '@angular/core';
import { User } from '../user';
import { LoginuserService } from 'src/app/loginuser.service';
import { Router } from '@angular/router';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
@Injectable({
  providedIn: 'any'
})
export class UserLoginComponent implements OnInit {
  user: User = new User();
  constructor(private loginUserService: LoginuserService, private route: Router) { }

  ngOnInit(): void {
  }
  onSubmit() {
    console.log(this.user);
    this.loginUserService.loginUser(this.user).subscribe(
      result => {
        console.log("success")
        alert("Welcome!!! Logged in successfully");
       this.route.navigate(['/register']);

      },
      error => {
        alert("Something went wrong, credentials are not correct");

      }

    )
  }
 goToRegister() {
      this.route.navigate(['/register']);
    }
}
