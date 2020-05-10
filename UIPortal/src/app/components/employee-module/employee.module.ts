import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

/**
 * Employee Route
 */
const routes: Routes = [
  {path: 'list', component: EmployeeListComponent },
  {path: 'add', component: CreateEmployeeComponent},
  {path: 'details', component: EmployeeDetailsComponent}
];

@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes), FormsModule, ReactiveFormsModule, RouterModule
  ],
  declarations: [
      CreateEmployeeComponent,
      EmployeeDetailsComponent,
      EmployeeListComponent,
      UpdateEmployeeComponent
  ]
})
export class EmployeeModule { }
