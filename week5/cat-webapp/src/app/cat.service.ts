import { MessageService } from './message.service';
import { Cat } from './cat';
import { CATS } from './mock-cats';
import { Injectable } from '@angular/core';
import { Observable, of }  from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
// RxJS is a library for composing asynchronous and event-based programs

// This decorator allows this service to be used (or INJECTED)
@Injectable({
  providedIn: 'root'
})

// inject HttpClient in the constructor
export class CatService {

  httpOptions = {
    headers: new HttpHeaders(
      {'Content-Type': 'application/json'}
    )
  }
  // this is linking to :base/:collectionName
  // in this case, our BASE API is in-memory-data-service
  // ... our collectionName is cats
  private catsUrl = 'api/cats'; // this is the URL to the web api

  // we are injecting a message service into our cat service
  //... all of which will be available to our Cat component
  constructor(
    private messageService: MessageService,
    private http: HttpClient
    ) { }

  // this is a synchronous method signature
  // getCats(): Cat[] {
  //   return CATS;
  // }

  //** GET cats from the server */
  getCats(): Observable<Cat[]> {
    // let's also send a message after fetching all of the cats
    this.messageService.add('CatService: fetched cats')
    return this.http.get<Cat[]>(this.catsUrl)
      .pipe(
        // tap allows us to DO something with the values
        // without changing the values themselves
        tap(_=> this.log('fetched cats!')),
        catchError(this.handleError<Cat[]>('getCats', []))
      );
   }

   // 1.) PIPES in ANGULAR take data and format it in a particular way
   // 2.) PIPE() in RxJS is a function 

   /**GET -- this is also an HTTP Get request to our mock server */
   getCat(id: number): Observable<Cat> {
     // let's also send a message saying that we fetched a particular cat:
      const url = `${this.catsUrl}/${id}`; // here we are constructing a URL with the desired cat's ID
      return this.http.get<Cat>(url)
      .pipe(
        // tap allows us to DO something with the values
        // without changing the values themselves
        tap(_=> this.log(`fetch cat id=${id}`)),
        catchError(this.handleError<Cat>(`getCat id=${id}`))
      );


    //  this.messageService.add(`CatService: fetched cat w/ id=${id}`);
    //  return of(CATS.find(cat => cat.id === id));
   }

   /** This is a PUT request  (we make changes to the server regarding one CAT that lives there
    * There are 3 params to the HttpClient.put() method:
    * 
    * 1. the URL
    * 2. the data to update (i mean the Cat object)
    * 3. options
    * 
   */
  updateCat(cat: Cat): Observable<any> {
    return this.http.put(this.catsUrl, cat, this.httpOptions)
      .pipe(
        tap(_=> this.log(`updated cat with id of ${cat.id}`)),
        catchError(this.handleError<any>('updateCat'))
      );
  }

  /**POST request! 
  */
  addCat(cat: Cat): Observable<Cat> {
    return this.http.post(this.catsUrl, cat, this.httpOptions)
    .pipe(
      tap((newCat: Cat) => this.log(`added cat with id of ${newCat.id}`)),
        catchError(this.handleError<any>('addCat'))
    )
  }


   private log(message: string) {
     this.messageService.add(`CatService: ${message}`);
   }

   /**DELETE delete the cat from the server */
   deleteCat(cat: Cat | number): Observable<Cat> {
     const id = typeof cat === 'number' ? cat : cat.id;
     const url = `${this.catsUrl}/${id}`;

     return this.http.delete<Cat>(url, this.httpOptions)
     .pipe(
       tap(_=> this.log(`deleted cat id =${id}`)),
       catchError(this.handleError<Cat>('deleteCat'))
     )

   }


   /**
    * Handle HTTP operation that failed 
    * Let the app continue
    * @param operation - name of the operation that fails
    * @param result - optional value to return as the OBSERVABLE result 
    */
   private handleError<T>(operation = 'operation', result?: T) {
     return (error: any): Observable<T> => {
        // send the error to a remote logging infrastructure
        console.error(error)  // this will log it to the console instead
     
        this.log(`${operation} failed: ${error.message}`);

        // this step lets the app keep running by returning an empty result
        return of(result as T);
      }
      // After reporting the error to the console, the handler
      // a message (user friendly) and return a safe value.
   }

}
