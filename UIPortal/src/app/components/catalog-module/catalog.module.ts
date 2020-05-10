import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CatalogModuleComponent } from './catalog-module.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

/**
 * Catalog Route
 */
const routes: Routes = [
  {path: 'list', component: CatalogModuleComponent }
];
@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(routes), FormsModule, ReactiveFormsModule, RouterModule
  ],
  declarations: [CatalogModuleComponent]
})
export class CatalogModule { }
