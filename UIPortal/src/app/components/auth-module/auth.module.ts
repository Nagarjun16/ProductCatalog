import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

/**
 * Auth Module Route
 */
const routes: Routes = [

];

@NgModule({
  imports: [
    CommonModule,
    CommonModule, RouterModule.forChild(routes), FormsModule,
    CommonModule, ReactiveFormsModule, RouterModule
  ],
  declarations: []
})
export class AuthModule { }
