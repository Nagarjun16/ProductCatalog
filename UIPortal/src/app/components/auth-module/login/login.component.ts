import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Login } from 'src/app/model/login';
import { session } from 'src/app/common/session';
import { DropdowndataService } from 'src/app/services/dropdowndata.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup = new FormGroup({
    userid: new FormControl('', Validators.required),
    department: new FormControl('', Validators.required),
  });
  errorMessage: string;
  departmentList: any;

  constructor(private authService: AuthService, private dropdowndataService: DropdowndataService) { }

  ngOnInit() {
    this.dropdowndataService.getDepartmentList().subscribe(data => {
      this.departmentList = data;
    });
  }

  isAuthorized() {
    return this.authService.isAuthorized();
  }

  ForgotUser(event: Event){

  }

  LoginUser(event: Event) {
    // if there is direct one to one mapping you can use
    // this.loginForm.getRawValue() assign to login object

    const login: Login = new Login();
    login.id = this.loginForm.get('userid').value;
    login.department = (this.loginForm.get('department').value as any).value;

    this.authService.performLogin(login)
    .subscribe(data => {
      session.authToken = data.jwttoken;
    }, error => {
      this.errorMessage = 'Invalid Credentials';
    });
  }

}
