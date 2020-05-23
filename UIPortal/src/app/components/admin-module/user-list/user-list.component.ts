import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { UserDetails } from 'src/app/model/userdetails';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.sass']
})
export class UserListComponent implements OnInit {

  users: Observable<UserDetails[]>;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.users = this.userService.getUserList();
  }

  unregisterUser(id: number) {
    this.userService.unregisterUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updateUser(id: number) {
    this.router.navigate(['details']);
  }

}
