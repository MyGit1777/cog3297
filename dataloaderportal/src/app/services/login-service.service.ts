import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  url = "http://localhost:8081/dataloader"
  constructor(private httpClient: HttpClient) { }

 performLogin(credentials: any) {

    return this.httpClient.post(`${this.url}/authenticate`, credentials)
  }

  getUser(){
    let jtoken= 'Bearer ' +localStorage.getItem("token");
    const headers = new HttpHeaders().set("Authorization", jtoken);
      // return this.httpClient.get<any>("http://localhost:8081/dataloader/2", {headers, responseType: 'text' as 'json'});
      return this.httpClient.get<any>("http://localhost:8081/dataloader/2", {responseType: 'text' as 'json'});
    }


  loginUser(token: string){

    localStorage.setItem("token", token);
    
    return true;
  }
  getJWT(){
  return localStorage.getItem("token");
  }
  logoutUser() {
    localStorage.removeItem("token");
    return true;
  }
  isLoggedIn() {
    let token = localStorage.getItem("token");
    if (token == null || token == '' || token == undefined) {
      return false;

    } else {

      return true;
    }
  }

  getToken() {

    return localStorage.getItem("token");

  }
}