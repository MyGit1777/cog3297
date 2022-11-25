import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
 
  email:any
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
  forgotPassword(email: any) {
   
    this.email = localStorage.setItem("email", email);
   let queryParams = new HttpParams();
    queryParams = queryParams.append("email", email);
    console.log("this is url c"+ queryParams);
    return this.httpClient.post(`${this.url}/forgotPassword?${queryParams}`,{params:queryParams})

  }

  verifyEnteredOTP(otp: any) {
    let queryParams = new HttpParams();
    this.email = localStorage.getItem("email");
    queryParams = queryParams.append("otp", otp);
    queryParams = queryParams.append("email", this.email);
    console.log("this is url otp"+ queryParams);
    return this.httpClient.post(`${this.url}/verifyOTP?${queryParams}`,{params:queryParams})
  
  }
  getToken() {

    return localStorage.getItem("token");

  }

  changePassword(user: User) {

    return this.httpClient.post(`${this.url}/updateUser`, user)
  }
}
