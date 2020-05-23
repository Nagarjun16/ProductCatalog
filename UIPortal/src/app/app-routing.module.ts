import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/commons-module/login/login.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {
    path: 'Admin',
    loadChildren: () => import('./components/admin-module/admin.module').then(m => m.AdminModule)
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
