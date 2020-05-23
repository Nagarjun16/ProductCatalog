import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { UserDetails } from 'src/app/model/userdetails';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  id: number;
  userDetails: any;
  submitted = false;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.userDetails = new UserDetails();

    this.id = this.route.snapshot.params['id'];

    this.userService.getUserDetails(this.id)
      .subscribe(data => {
        console.log(data)
        this.userDetails = data;
      }, error => console.log(error));
  }

  updateUser(){
    this.userService.updateUser(this.id, this.userDetails)
        .subscribe(data => console.log(data), error => console.log(error));
    this.userDetails = new UserDetails();
    this.gotoList();
  }

  onSubmit(){
    this.submitted = true;
    this.updateUser();
  }

  gotoList(){
    this.router.navigate(['/userlist']);
  }
}
