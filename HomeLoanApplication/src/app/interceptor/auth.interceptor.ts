import { Injectable, Injector } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from '../services/login/login.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private loginService: LoginService,private injector: Injector) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
       
    let token = this.injector.get(LoginService).getToken();
    let newReq = req;
    if (token != null) {
        newReq = newReq.clone({ setHeaders: { Authorization: `Bearer ${token}` } })
    }
    return next.handle(newReq);
}
}
