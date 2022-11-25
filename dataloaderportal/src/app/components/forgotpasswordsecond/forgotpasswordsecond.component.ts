import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-forgotpasswordsecond',
  templateUrl: './forgotpasswordsecond.component.html',
  styleUrls: ['./forgotpasswordsecond.component.css']
})
export class ForgotpasswordsecondComponent implements OnInit {
  otp:any
  constructor(private route: Router, private loginservice: LoginServiceService) { }

  ngOnInit(): void {
  }
  verifyOTP(){
    console.log("Inside verify otp");
    this.loginservice.verifyEnteredOTP(this.otp).subscribe(
      (result: any) => {
      
        if(result==true){
          console.log("otp verified successfully");
          alert("OTP verified successfully!!");    
          window.location.href = "/changePassword";
        }else{
          alert("Something went wrong, please check otp once");  

        }
      },
      (error: any) => {
        console.log("error occured while verifying an OTP")
        alert("Something went wrong, please check otp once");

      }
    )
    
    
  }
}
