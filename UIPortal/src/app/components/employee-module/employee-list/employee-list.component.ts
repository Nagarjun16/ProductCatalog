import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.sass']
})
export class EmployeeListComponent implements OnInit {

  users: Observable<Employee[]>;

  constructor(private employeeService: EmployeeService , private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.users = this.employeeService.getEmployeesList();
  }

 deleteEmployee(id: number){
  this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
 }
 employeeDetails(id: number){
   this.router.navigate(['details']);
 }

}
