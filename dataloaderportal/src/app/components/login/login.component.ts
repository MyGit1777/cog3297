import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials = {
    userName: '',
    password: ''

  }
  user: any;
  constructor(private route: Router, private loginservice: LoginServiceService) { }

  ngOnInit(): void {
  
    
  }
  onSubmit() {

    console.log("Ready to send credentials");
    this.loginservice.performLogin(this.credentials).subscribe(
      (result: any) => {
        console.log("this is token" +result.jwt);
        
        this.loginservice.loginUser(result.jwt);
      
      // this.route.navigateByUrl('/home');
     window.location.href = "/home";
      },
      error => {
        console.log("error occured")
        alert("Something went wrong, please check credentials once");

      }

    )
  }
}
