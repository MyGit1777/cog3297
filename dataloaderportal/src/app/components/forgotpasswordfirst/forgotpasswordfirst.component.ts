import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-forgotpasswordfirst',
  templateUrl: './forgotpasswordfirst.component.html',
  styleUrls: ['./forgotpasswordfirst.component.css']
})
export class ForgotpasswordfirstComponent implements OnInit {
  email: any
  constructor(private route: Router, private loginservice: LoginServiceService
  ) { }

  ngOnInit(): void {
  }
  sendOTP() {
    if(this.email == '' || this.email == null){
      alert("Please enter your mail");
    }else{
    console.log("Inside send otp" + this.email);
    this.loginservice.forgotPassword(this.email).subscribe(
      (result: any) => {
        if (result == true) {
          alert("OTP sent successfully!!");
          window.location.href = "/verifyOTP";
        } else {
          alert("Something went wrong, please check email once");

        }
      },
      (error: any) => {
        console.log("error occured while sending an OTP")
        alert("Something went wrong, please check email once");

      }
    )
    }
  }
}
