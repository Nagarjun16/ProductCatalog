import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './components/commons-module/login/login.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { LoaderComponent } from './components/commons-module/loader/loader.component';
import { LoaderService } from './services/Loader.service';
import { AppHttpInterceptorService } from './components/commons-module/AppHttpInterceptor.service';

@NgModule({
   declarations: [
      AppComponent, LoginComponent, LoaderComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      FormsModule,
      ReactiveFormsModule,
      HttpClientModule,
      FontAwesomeModule,
      BrowserAnimationsModule,
      MatSelectModule,
      MatProgressSpinnerModule
   ],
   providers: [LoaderService,
      { provide: HTTP_INTERCEPTORS, useClass: AppHttpInterceptorService, multi: true }],
   bootstrap: [
      AppComponent, LoginComponent
   ]
})
export class AppModule { }
