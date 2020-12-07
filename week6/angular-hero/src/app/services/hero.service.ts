import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { ClientMessage } from './../models/client-message.model';
import { HERO_URL } from './../../environments/environment.prod';
import { Observable } from 'rxjs';
import { Hero } from './../models/hero.model';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/Rx';



@Injectable({
  providedIn: 'root'
})
export class HeroService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  }

  constructor(private http: HttpClient) { }

  public registerHero(hero: Hero): Observable<ClientMessage> {
    return this.http
      .post(`${HERO_URL}register`, hero, this.httpOptions).pipe(
        catchError(this.handleError<any>('not working'))
      )

  }

  public findHero(hero: Hero): Observable<Hero> {
    return this.http
      .post(`${HERO_URL}register`, hero)
      .catch(this.handleError)
  }


  public findAllHeroes(): Observable<Hero[]> {
    return this.http
      .get(`${HERO_URL}findAllHeroes`)
      .catch(this.handleError);
    }

  // private handleError(error: HttpErrorResponse) {
  //   if (error.error instanceof ErrorEvent) {
  //     // A client-side or network error occurred. Handle it accordingly.
  //     console.error('An error occurred:', error.error.message);
  //   } else {
  //     // The backend returned an unsuccessful response code.
  //     // The response body may contain clues as to what went wrong.
  //     console.error(
  //       `Backend returned code ${error.status}, ` +
  //       `body was: ${error.error}`);
  //   }
  //   // Return an observable with a user-facing error message.
  //   return throwError(
  //     'Something bad happened; please try again later.');
  // }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }
  
}
