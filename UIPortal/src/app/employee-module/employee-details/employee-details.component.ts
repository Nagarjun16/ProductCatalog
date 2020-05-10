import { Component, OnInit, Input } from '@angular/core';
import { Employee } from '../../employee';
import { EmployeeService } from '../../employee.service';
import { EmployeeListComponent } from '../employee-list/employee-list.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.sass']
})
export class EmployeeDetailsComponent implements OnInit {
  id: number;
  employee: any;
  
  constructor(private route: ActivatedRoute,private router: Router,private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employee = new Employee();
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployee(this.id)
        .subscribe(data => {
          console.log(data)
          this.employee = data;
        },error => console.log(error));
  }

  list(){
    this.router.navigate(['/employees']);
  }
  
  // updateActive(value:any){
  //   this.employee.active = value;
  // }
  // deleteEmployee(id){
  //   this.employeeService.deleteEmployee(id);
  // }
}
