import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginuserService {

  constructor(private http: HttpClient) { }
  loginUser(user: User): Observable<Object> {
    console.log(user);
    return this.http.post("http://localhost:9199/dmart/login", user);
  }
  createUser(user: User): Observable<Object> {
    console.log(user);
    return this.http.post("http://localhost:9199/dmart/createUser", user);
  }

  getAllProducts(): Observable<any> {
    return this.http.get<any>('http://localhost:9199/dmart/getAllProducts');
  }

  addProduct(product: Product): Observable<any> {
    return this.http.post<any>('http://localhost:9199/dmart/createProduct', product);
  }

  deleteProductBdyId(id: number): Observable<any> {
    return this.http.delete<any>('http://localhost:9199/dmart/delete/' + id);

  }
  getProductById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:9199/dmart/getProduct/' + id);

  }

  logUser(user: User){

    localStorage.setItem("user", user.userName);
   
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
