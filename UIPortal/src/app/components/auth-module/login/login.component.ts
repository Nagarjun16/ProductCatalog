import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Login } from 'src/app/model/login';
import { session } from 'src/app/common/session';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  constructor(private authService: AuthService ) { }

  ngOnInit() {
  }

  isAuthorized() {
    return this.authService.isAuthorized();
  }

  ForgotUser(event: Event){

  }

  LoginUser(event: Event){
    const login: Login = this.loginForm.getRawValue();
    this.authService.performLogin(login).subscribe(data => {
      if (data.active) {
        session.authToken = data.authToken;
        session.emailId = data.emailId;
        session.username = data.session;
      }
    }, error => console.log(error));
  }

}
