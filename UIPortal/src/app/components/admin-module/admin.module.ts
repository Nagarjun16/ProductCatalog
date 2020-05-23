import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { UpdateUserComponent } from './update-user/update-user.component';

/**
 * Admin Module Route
 */
const routes: Routes = [
  {path: 'userlist', component: UserListComponent },
  {path: 'adduser', component: CreateUserComponent},
  {path: 'update', component: UpdateUserComponent}
];

@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes), FormsModule, ReactiveFormsModule, RouterModule
  ],
  declarations: [
    UserListComponent,
    CreateUserComponent,
    UpdateUserComponent
  ]
})
export class AdminModule { }
