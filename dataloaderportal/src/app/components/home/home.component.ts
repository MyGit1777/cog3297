import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private loginservice: LoginServiceService) { }

  ngOnInit(): void {

    this.loginservice.getUser().subscribe(
      (result: any) => {
       
        console.log("User caall exceuted"+ result);
      },
      error => {
        console.log("User caall failed"+ error);

      }

    )
  }

}
