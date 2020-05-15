import { Injectable } from '@angular/core';
import { Login } from '../model/login';
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
    //const baseUrl = ApiConfig.serviceURL + ApiConfig.performLogin;
    //return this.http.get(baseUrl);
    return ObservableOf({authToken: 'E29101773I889332100221222222',
    userName: request.username,
    active: true });
  }

  public forgotPassword(request: Login): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.updatePassword;
    return this.http.post(baseUrl, Login);
  }

  public isAuthorized() {
    return (!session.authToken || session.authToken === '') ? false : true;
  }
}
