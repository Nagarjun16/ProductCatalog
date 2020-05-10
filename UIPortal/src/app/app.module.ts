import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './employee-module/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee-module/employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-module/employee-list/employee-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateEmployeeComponent } from './employee-module/update-employee/update-employee.component';

@NgModule({
   declarations: [
      AppComponent,
      CreateEmployeeComponent,
      EmployeeDetailsComponent,
      EmployeeListComponent,
      UpdateEmployeeComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      FormsModule,
      HttpClientModule
   ],
   providers: [],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
