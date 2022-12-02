import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = new User();

  constructor(private actRoute: ActivatedRoute, private loginService: LoginServiceService) { }

  ngOnInit(): void {
  }
  addNewUser() {
    let cred = this.user;
    if(cred.firstName == '' || cred.firstName == null || cred.lastName == '' || cred.lastName==null || cred.userName == '' || cred.userName == null || cred.password == '' || cred.password == null){
    alert("All fields are mandatory");

    }else{
    this.loginService.createUser(this.user).subscribe
      (
        data => {
          console.log("Registered successfully");
          alert("Registered successfully");
          window.location.href = "/home";
        },
        error => {

          console.log("Error while creating user");
          alert("Could not register, please try again");
        }

      )
    }
  }
}
