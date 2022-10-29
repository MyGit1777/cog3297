import { Component, OnInit } from '@angular/core';
import {NgserviceService} from '../ngservice.service';
import {Router} from '@angular/router';
import { Course } from '../course';


@Component({
  selector: 'app-courselist',
  templateUrl: './courselist.component.html',
  styleUrls: ['./courselist.component.css']
})
export class CourselistComponent implements OnInit {
  courses: Array<Course> = [];
  constructor(private _route: Router, private _service: NgserviceService) { }
  ngOnInit(): void {
   
    this.getCourses();
  }
  getCourses() {
    this._service.fetchCourseListFromRemote().subscribe(
      data => this.courses = data, error => console.log("Exception occurred 1"),
    )
  }
  isEmpty()
  {
    if (this.courses == null)
    {
      return true;
    }
    else { return false; }
  }
 
  goToAddCourse() {
    this._route.navigate(['/addcourse']);
  }
 
  goToUpdateCourse(id: number) {
    console.log("id: "+ id);
    this._route.navigate(['/editcourse', id]);
  }
 
  goToViewCourse(id: number){
    this._route.navigate(['/viewcourse', id]);
 
  }
 
  deleteCourse(id: number) {
    if (confirm('Are you sure ?'))
  return this._service.deleteCourseBdyIdFromRemote(id).subscribe(
    success =>{
      ("Product deleted succesfully");
    },
    error=> {console.log("Exception occured 2"); this.getCourses()}
   )
  }
 
}

 
