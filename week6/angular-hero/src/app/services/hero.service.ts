import { HERO_URL } from './../../environments/environment.prod';
import { Observable } from 'rxjs';
import { Hero } from './../models/hero.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  constructor(private http: HttpClient) { }

  public registerHero(hero: Hero): Observable<Hero> {
    return this.http
      .post(`${HERO_URL}register`, hero)
      .catch(this.handleError);
  }

  public findHero() {

  }


  public findAllHeroes() {

  }


  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }
}
