import { Cat } from './cat';
import { CATS } from './mock-cats';
import { Injectable } from '@angular/core';
import { Observable, of }  from 'rxjs';
// RxJS is a library for composing asynchronous and event-based programs

// This decorator allows this service to be used (or INJECTED)
@Injectable({
  providedIn: 'root'
})
export class CatService {

  constructor() { }

  getCats(): Observable<Cat[]> {
    return of(CATS);
    // of(CATS) we want to return an Observable (an array of Cats).  This will emit a single value

    // An observable is a function with a few special characteristics
    //...It implements something called an Observer Design Pattern
    //...An Observable returns a stream of vlaues to an observer over time
    // this can be done synchronously or asynchronously

    /*
    We get Observables from the RxJS library (Reactive Extensions for JavaScript)
   - RxJS gives us functions to make it easier to compose asynchronous based ced code.

    */
  }

}
