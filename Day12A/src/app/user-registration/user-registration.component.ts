import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';

import { Router } from '@angular/router';
import { LoginuserService } from '../loginuser.service';
import {NgForm} from '@angular/forms';
import { User } from '../user';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
@Injectable({
  providedIn: 'any'
})
export class UserRegistrationComponent implements OnInit {
  
  user: User = new User();
  constructor(private loginUserService: LoginuserService,private route: Router) {
   }

  ngOnInit(): void {
  }
    
    onSubmit() {
      console.log(this.user);
      this.loginUserService.registerUser(this.user).subscribe(
        result => {
          console.log("register success")
          alert("Registered successfully");  
  
        },
        error => {
          alert("Something went wrong, could not register");
  
        }
  
      )
    }
}
