import { Component, OnInit } from '@angular/core';
import { LoginuserService } from '../loginuser.service';
import { User } from '../user';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private loginService: LoginuserService) { }
  user: User = new User();
  ngOnInit(): void {
  }
  userLogin() {

    //   console.log(this.user);
    //   this.loginService.loginUser(this.user).subscribe(result=>{
    //   alert("Logged in successfully");
    //   window.location.href="/viewProducts";

    //   }, error=>{

    //     alert("Oops!! Could not login");

    //   }

    //     )

    console.log(this.user);
    if (this.user.password != null && this.user.password != '' && this.user.userName != null && this.user.userName != '') {
      console.log("Ready to send credentials");
      this.loginService.loginUser(this.user).subscribe(
        result => {
          console.log("suceed");
          alert("Logged in successfully");
          window.location.href = "/home";
          this.loginService.logUser(this.user);
        },
        error => {
          console.log("error occured");
          alert("Oops!! Could not login");

        }

      )
    } else {

      console.log("credentials are not okay");
      alert("Oops!! Could not login");
    }



  }


}
