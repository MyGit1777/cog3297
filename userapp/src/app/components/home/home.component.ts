import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from 'src/app/book';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public loggedIn = false;
  user: any;
  book = new Book();
  constructor(private actRoute: ActivatedRoute, private loginservice: LoginserviceService) { }
  ngOnInit(): void {

    this.loggedIn = this.loginservice.isLoggedIn();
    this.user = localStorage.getItem("user");
    console.log("this is dash" + this.user);
  }
  searchBook() {

    this.loginservice.createBook(this.book).subscribe
      (
        data => {
          console.log("Registered successfully");
          alert("Registered successfully");
          window.location.href = "/dashboard";
        },
        error => {

          console.log("Error while creating user");
        }

      )

  }

  resetForm() {
   
    
  }
}
