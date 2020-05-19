import { Injectable } from '@angular/core';
import { Login, LoginResponse } from '../model/login';
import { Observable, of as ObservableOf} from 'rxjs';
import { ApiConfig } from '../common/config';
import { HttpClient } from '@angular/common/http';
import { session } from '../common/session';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

constructor(private http: HttpClient) { }

  public performLogin(request: Login): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.performLogin;
    return this.http.post(baseUrl, request);
  }

  public isAuthorized() {
    return (!session.authToken || session.authToken === '') ? false : true;
  }
}
