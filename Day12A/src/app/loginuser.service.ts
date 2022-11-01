import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginuserService {
 private url = "http://localhost:9199/user/login";

  constructor(private http: HttpClient) { }
  loginUser(user: User): Observable<Object> {

return this.http.post(`${this.url}`, user);

  }

  registerUser(user: User): Observable<Object> {

    return this.http.post("http://localhost:9199/user/create", user);
    
      }
}
