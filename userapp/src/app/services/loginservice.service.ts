import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';


@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {
  getUrl = "http://localhost:8088/user/";
  url = "http://localhost:8088/user/login";

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer foo' 
    })
  };
  performLogin(user: User): Observable<any> {


    user.role = 'GUEST';
    console.log(user);
    // return this.http.post<any>("http://localhost:8088/user/login",user);
    //return this.http.get<User>("http://localhost:8088/user/"+6);

    return this.http.post<any>(`${this.url}`, user);
  }
  getUser(user: User): Observable<any> {


    user.role = 'GUEST';
    console.log(user);

    return this.http.get<User>("http://localhost:8088/user/" + 6);
  }

  createUser(user: User): Observable<any> {
    user.role = 'GUEST';
    console.log(user);
    return this.http.post<any>("http://localhost:8088/user/create", user);
  }
  loginUser(user: User){

    localStorage.setItem("user", user.userName);
    return true;
  }

  logoutUser(){

    localStorage.removeItem("user");
  }
  isLoggedIn(){
let user = localStorage.getItem("user");
 if(user==null ||user=='' || user==undefined ){
return false;

 }else{

  return true;
 }
  }
}
