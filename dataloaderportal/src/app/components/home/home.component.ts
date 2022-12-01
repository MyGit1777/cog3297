import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private route: Router, private loginservice: LoginServiceService) { }
  flowname='';
  ngOnInit(): void {

    this.loginservice.getUser().subscribe(
      (result: any) => {
       
        console.log("User caall exceuted"+ result);
      },
      error => {
        console.log("User call failed"+ error);

      }

    )
  }
  processData(){
    this.flowname='processData'
    let flowname = this.flowname;

    this.route.navigate(['/viewAndUpdate', flowname]);
  }

  updateData(){
    this.flowname='updateData'
    let flowname = this.flowname;
    this.route.navigate(['/viewAndUpdate', flowname]);
  }
}
