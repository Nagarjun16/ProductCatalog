import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.sass']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save(){
    this.employeeService.createEmployee(this.employee)
        .subscribe(data => console.log(data),error => console.log(error));
    this.employee = new Employee();
    this.gotoList();
  }

  onSubmit(){
    this.submitted = true;
    this.save();
  }
  gotoList(){
    this.router.navigate(['/employees']);
  }

}
