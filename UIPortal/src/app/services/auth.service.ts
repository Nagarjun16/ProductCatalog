import { Injectable } from '@angular/core';
import { Login } from '../model/login';
import { Observable } from 'rxjs';
import { ApiConfig } from '../common/config';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

constructor(private http: HttpClient) { }

  public login(request: Login): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.getEmployeeList;
    return this.http.get(`${baseUrl}`);
  }

  public forgotPassword(request: Login): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.getEmployeeList;
    return this.http.get(`${baseUrl}`);
  }
}
