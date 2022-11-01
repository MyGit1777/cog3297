import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { LoginuserService } from '../loginuser.service';
import { User } from '../user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user = new User();
 
  constructor(private actRoute: ActivatedRoute , private loginService: LoginuserService) { }

  ngOnInit(): void {
  }
  addNewUser(){
   
    this.loginService.createUser(this.user).subscribe
    (
      data =>{
        console.log("Registered successfully");
        alert("Registered successfully");
        window.location.href="/home";
      },
      error =>{

        console.log("Error while creating user");
        alert("Could not register, please try again");
      }
     
    )
   
  }
}
