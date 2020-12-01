import { CatService } from './../cat.service';
import { Observable, Subject } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Cat } from "./../cat";
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-cat-search',
  templateUrl: './cat-search.component.html',
  styleUrls: ['./cat-search.component.css']
})
export class CatSearchComponent implements OnInit {

  cats$: Observable<Cat[]>;
  private searchTerms = new Subject<string>();
  // a Subject is both a source of observable values AND an observable itself
  // you can subscribe to it
  // we can push values to it


  constructor(private catService: CatService) { }

  ngOnInit(): void {

    this.cats$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering a term
      debounceTime(300),

      // ignore new term if same as previosu term
      distinctUntilChanged(),

      // switch to a new search observable
      switchMap((term: string) => this.catService.searchCats(term)),

    )

  }

  search(term: string): void {
    this.searchTerms.next(term)
    // the next(value) takes in a param and pushes it to the subject (which is an observable)
  }

}
