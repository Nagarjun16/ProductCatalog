import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiConfig } from '../common/config';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getEmployee(id: number): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.getEmployeeList;
    return this.http.get(`${baseUrl}/${id}`);
  }

  createEmployee(employee: object): Observable<object>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.generateEmployee;
    return this.http.post(`${baseUrl}`, employee);
  }

  updateEmployee(id: number, value: any): Observable<object>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.updateEmployee;
    return this.http.put(`${baseUrl}/${id}`, value);
  }

  deleteEmployee(id: number): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.deleteEmployee;
    return this.http.delete(`${baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any>{
    const baseUrl = ApiConfig.serviceURL + ApiConfig.getEmployeeList;
    return this.http.get(baseUrl);
  }
}
