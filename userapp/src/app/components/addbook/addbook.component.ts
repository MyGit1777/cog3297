import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/book';
import { LoginserviceService } from 'src/app/services/loginservice.service';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {

  book = new Book();
  constructor(private route: Router, private actRoute: ActivatedRoute, private loginService: LoginserviceService) { }

  ngOnInit(): void {
  }


  addBookSubmit() {
    this.loginService.createBook(this.book).subscribe
      (
        data => {
          console.log("Data added successfully");
          this.route.navigate(['home']);
        },
        error => console.log("Error")
      )
  }
  gotoDashboard() {
    this.route.navigate(['dashboard']);
  }
}
