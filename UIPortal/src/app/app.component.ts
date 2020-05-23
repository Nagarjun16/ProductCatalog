import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'Project Overview System';

  constructor(private authService: AuthService, private router: Router ) { }

  isAuthorized() {
    return this.authService.isAuthorized();
  }

  logout(event: Event){
    event.preventDefault();
    this.authService.removeAuthData();
    this.router.navigate(['login']);
  }
}
