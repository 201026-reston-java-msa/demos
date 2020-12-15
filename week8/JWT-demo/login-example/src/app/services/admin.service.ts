import { AdminDetail } from './../classes/admin-detail';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';



@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl = "http://localhost:8080/LoginLogoutExample/api/";

  constructor(private http: HttpClient, private router: Router) { }

  saveAdminDetail(adminDetail: AdminDetail): Observable<any> {
    let url = this.baseUrl + "saveAdmin";
    return this.http.post(url, adminDetail);
  }

  login(adminDetail: AdminDetail): Observable<any> {
    let url = this.baseUrl + "login";
    return this.http.post(url, adminDetail);
  }

  logout() {
    // remove the token from the localSt
    localStorage.removeItem('token');

    this.router.navigate([""]);
  }

  isLoggedIn() {

    // first, create an instance of JWT Helper Class
    let jwtHelper = new JwtHelperService();

    // get token from the localStorage since we have to work with this particular token
    let token = localStorage.getItem('token');

    // JWT -- JSON Web Token
    /*
    Consists of a Header, a Payload and a Signature
    Typically looks like xxx.yyy.zzz

    Once a user is signed in -- each request will include the JWT, which allows the User
    to access routes, services, and resources that are permitted with that token

    JWT is used for Authoriztion and Info Exchange.
    */

    if (!token) {
      return false;
    }

    // check whether the token is expired or not
    if (token) {
      let expirationDate = jwtHelper.getTokenExpirationDate(token)

      let isExpired = jwtHelper.isTokenExpired(token)

      return !isExpired;
    }
  }

  getAdminDetail(adminId): Observable<any>{

    //get url being mapped to
    let url = this.baseUrl+"getAdminData/"+adminId;

    //get token from local storage
    let token = localStorage.getItem('token')

    //create instance of header object
    //create object of RequestOptions and include the header
    //append the Authorization header

    const options = {
      headers : new HttpHeaders().append('Authorization', 'Bearer' + token)
    }

    //options is only containing our headers (or token)
    return this.http.get(url, options);
  }



}
