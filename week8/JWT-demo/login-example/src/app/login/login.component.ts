import { AdminDetail } from './../classes/admin-detail';
import { Router } from '@angular/router';
import { AdminService } from './../services/admin.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private adminDetail = new AdminDetail();

  constructor(private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {

    if((this.adminService.isLoggedIn)) {
      this.router.navigate(['/profile', localStorage.getItem('id')]);
    } else {
      this.router.navigate(['/login'])
    }
  }

  // create the form object which we'll work with 
  form = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })

  Login(LoginInformation) {
    this.adminDetail.emailId = this.Email.value;
    this.adminDetail.password = this.Password.value;

    this.adminService.login(this.adminDetail).subscribe(
      response => {
        let result = response.json();

        if (result > 0) {
          let token = response.headers.get("Authorization");

          localStorage.setItem("token", token);
          localStorage.setItem("id", response);

          this.router.navigate(['/profile', result])
        }
        
        if (result == -1 ) {
          alert("invalid Email/Password combo")
        }
      },
      error => {
        console.log("Error in authentication")
      }
    )
  }



  get Email() {
    return this.form.get('email');
  }

  get Password() {
    return this.form.get('password');
  }

}
