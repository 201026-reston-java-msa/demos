import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{

  createDb() {
    const cats = [
      { id: 11, name: 'Flavius'},
      { id: 12, name: 'Pablo' },
      { id: 13, name: 'Tracy'},
      { id: 14, name: 'Artemis'},
      { id: 15, name: 'Nico'},
      { id: 16, name: 'Fluffy'},
      { id: 17, name: 'Clancy'},
      { id: 18, name: 'Mr. Pebbles'},
      { id: 19, name: 'Spot'},
      { id: 20, name: 'Eduardo'},
      { id: 21, name: 'Isa'},
      { id: 22, name: 'Sophia'},
      { id: 23, name: 'Azhya'}
    ];
    return {cats};
  }

  constructor() { }
}
