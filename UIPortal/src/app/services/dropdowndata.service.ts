import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiConfig } from '../common/config';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DropdowndataService {

constructor(private http: HttpClient) { }

  getDepartmentList(): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.departmentList;
    return this.http.get(baseUrl);
  }

}
