import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  users: Array<object> = [
    {
      id: '1',
      name: 'Jane',
      role: 'Designer',
      pokemon: 'Blastoise'
    },
    {
      id: '2',
      name: 'Bob',
      role: 'Developer',
      pokemon: 'Charizard'
    },
    {
      id: '3',
      name: 'Jim',
      role: 'Developer',
      pokemon: 'Venusaur'
    },
    {
      id: '4',
      name: 'Adam',
      role: 'Designer',
      pokemon: 'Raichu'
    }

  ]

  constructor() { }

  all(): Observable<Array<object>> {
    return of(this.users);
  }
}
