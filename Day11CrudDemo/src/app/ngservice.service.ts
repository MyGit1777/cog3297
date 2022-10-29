import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Course } from './course';


@Injectable({
  providedIn: 'root'
})
export class NgserviceService {

  constructor(private _http: HttpClient) { }

  fetchCourseListFromRemote(): Observable<any>{
    return this._http.get<any>('http://localhost:8181/course');
  }

  addCourseToRemote(course: Course): Observable<any>{
    return this._http.post<any>('http://localhost:8181/course/create', course);
  }

  updateCourseListFromRemote(course: Course): Observable<any>{
    return this._http.post<any>('http://localhost:8181/course/update', course);
  }
  deleteCourseBdyIdFromRemote(id: number): Observable<any>{
    return this._http.delete<any>('http://localhost:8181/course/delete/'+ id);

  }

}
