import { UserService } from './../services/users/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  users;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.all().subscribe(res => {
      this.users = res;
    });
  }

}
