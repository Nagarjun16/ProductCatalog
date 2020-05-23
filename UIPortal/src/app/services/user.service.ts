import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiConfig } from '../common/config';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUserDetails(id: number): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.getUserList;
    return this.http.get(`${baseUrl}/${id}`);
  }

  registerUser(userDetails: object): Observable<object>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.registerUser;
    return this.http.post(`${baseUrl}`, userDetails);
  }

  updateUser(id: number, value: any): Observable<object>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.updateUser;
    return this.http.put(`${baseUrl}/${id}`, value);
  }

  unregisterUser(id: number): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.unregisterUser;
    return this.http.delete(`${baseUrl}/${id}`, { responseType: 'text' });
  }

  getUserList(): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.getUserList;
    return this.http.get(baseUrl);
  }
}
