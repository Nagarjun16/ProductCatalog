import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { LoaderService } from 'src/app/services/Loader.service';
import { session } from 'src/app/common/session';

@Injectable({
  providedIn: 'root'
})
export class AppHttpInterceptorService implements HttpInterceptor {
  constructor(public loaderService: LoaderService) { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      this.loaderService.show();
      let headerJson: any;
      if (session.authToken) {
        headerJson = {
          Authorization: 'Bearer ' + session.authToken,
          Accept: 'application/json',
          'Access-Control-Allow-Credentials': 'true',
          'Content-Type': 'application/json'
        };
      }else{
        headerJson = {
          Accept: 'application/json',
          'Access-Control-Allow-Credentials': 'true',
          'Content-Type': 'application/json'
        };
      }

      const httpOptions = {
        headers: new HttpHeaders(headerJson)
      };

      request  = request.clone(httpOptions);

      return next.handle(request).pipe(
          finalize(() => this.loaderService.hide())
      );
  }

}
