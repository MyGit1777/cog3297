import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import { Course } from '../course';
import {NgserviceService} from '../ngservice.service';

@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css']
})
export class AddcourseComponent implements OnInit {

  course = new Course();
  constructor(private _route: Router,private _service: NgserviceService) { }

  ngOnInit(): void {
  }
  addCourseformsubmit()
  {
  this._service.addCourseToRemote(this.course).subscribe
  (
    data =>{
      console.log("Data added successfully");
      this._route.navigate(['courselist']);
    },
    error =>console.log("Error")
  )
  }
   
    gotolist() {
      this._route.navigate(['courselist']);
    }
   
}
