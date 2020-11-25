import { MessageService } from './message.service';
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
  // we are injecting a message service into our cat service
  //... all of which will be available to our Cat component
  constructor(private MessageService: MessageService) { }

  // this is a synchronous method signature
  // getCats(): Cat[] {
  //   return CATS;
  // }

  getCats(): Observable<Cat[]> {
    // let's also send a message after fetching all of the cats
    this.MessageService.add('CatService: fetched cats')
    return of(CATS);
    // of(CATS) we want to return an Observable (an array of Cats).  This will emit a single value

    // An observable is a function with a few special characteristics
    //...It implements something called an Observer Design Pattern
    //...An Observable returns a stream of values to an observer over time
    // this can be done synchronously or asynchronously

    /*
    We get Observables from the RxJS library (Reactive Extensions for JavaScript)
   - RxJS gives us functions to make it easier to compose asynchronous based ced code.

    */
   }

}
