import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 

 regex = new RegExp('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,20}$');
  loginForm = new FormGroup({
    userName: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.pattern(this.regex)),
  })

  user= new User();
  constructor(private route: Router, private loginservice: LoginServiceService) { }

  ngOnInit(): void {
  
    
  }
  get userName(){
return this.loginForm.get('userName')
  }
  get password(){
    return this.loginForm.get('password');
      }
  onSubmit() {
    // this.user.userName = this.loginForm.get('userName')?.value;
    this.user.userName=this.loginForm.value.userName;
    this.user.password=this.loginForm.value.password;

    console.log("Ready to send credentials");

    let cred = this.user;
    if(cred.userName=='' || cred.userName==null || cred.password==''|| cred.password == null){
      alert("Please check required fields");

    } else{
    console.log("Ready to send credentials");
    this.loginservice.performLogin(this.user).subscribe(
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
}
