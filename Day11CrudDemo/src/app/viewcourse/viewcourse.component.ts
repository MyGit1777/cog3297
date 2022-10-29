import { Component, OnInit } from '@angular/core';
import {NgserviceService} from '../ngservice.service';
import {ActivatedRoute, Router} from '@angular/router';
import { Course } from '../course';
@Component({
  selector: 'app-viewcourse',
  templateUrl: './viewcourse.component.html',
  styleUrls: ['./viewcourse.component.css']
})
export class ViewcourseComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
