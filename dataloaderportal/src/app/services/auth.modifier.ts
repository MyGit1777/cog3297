import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginServiceService } from "./login-service.service";

@Injectable()
export class AuthModifier implements HttpInterceptor {

  constructor(private loginservice: LoginServiceService) {
  }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let newRequest = req;
    let jwt = this.loginservice.getJWT();
    
    if(jwt!=null){
      newRequest = newRequest.clone({ setHeaders: { Authorization: `Bearer ${jwt}`}})
    }  console.log(newRequest);
    return next.handle(newRequest);
  }

}
