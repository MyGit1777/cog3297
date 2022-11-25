import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {
  user = new User();
  constructor(private route: Router, private loginservice: LoginServiceService) { }

  ngOnInit(): void {
  }

  changePassword() {

    if (this.user.password != this.user.password1) {
      alert("Confirm password is not matching")

    } else {
      this.user.userName = localStorage.getItem("email");
      this.loginservice.changePassword(this.user).subscribe(
        (result: any) => {
          console.log("password changed successfully");
          alert("Password changed successfully!!");
          window.location.href = "/login";
        },
        (error: any) => {
          console.log("error occured while changing password")
          alert("Something went wrong, error occured while changing password");

        }
      )
    }
  }
}
