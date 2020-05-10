import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./components/auth-module/auth.module').then(m => m.AuthModule)
  },
  {
    path: 'Employee',
    loadChildren: () => import('./components/employee-module/employee.module').then(m => m.EmployeeModule)
  },
  {
    path: 'Catalog',
    loadChildren: () => import('./components/catalog-module/catalog.module').then(m => m.CatalogModule)
  },
  { path: '**', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
