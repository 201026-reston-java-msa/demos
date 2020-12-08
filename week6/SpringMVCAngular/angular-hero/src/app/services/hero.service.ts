import { catchError } from 'rxjs/operators';
import { ClientMessage } from './../models/client-message.model';
import { HERO_URL } from './../../environments/environment.prod';
import { Observable } from 'rxjs';
import { Hero } from './../models/hero.model';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs'



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
      .post(`${HERO_URL}register`, hero, this.httpOptions)
      .pipe(
        catchError(this.handleError<any>('cannot register hero'))
      )
  }

  public findHero(hero: Hero): Observable<Hero> {
    return this.http
      .post<Hero>(`${HERO_URL}findHero`, hero)
      .pipe(
        catchError(this.handleError<Hero>('get hero', null))
      )
  }

  public findAllHeroes(): Observable<Hero[]> {
    return this.http
    .get<Hero[]>(`${HERO_URL}findAllHeroes`)
    .pipe(
      catchError(this.handleError<Hero[]>('getHeroes', []))
      );
    }

  private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
  
        // TODO: send the error to remote logging infrastructure
        console.error(error); // log to console instead

        // Let the app keep running by returning an empty result.
        return of(result as T);
      };
    }
  
}
