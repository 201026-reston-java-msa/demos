import { ClientMessage } from './../../models/client-message.model';
import { HeroService } from './../../services/hero.service';
import { Hero } from './../../models/hero.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {

  title = 'All Heroes';
  public heroes: Hero[] = [];
  public clientMessage: ClientMessage = new ClientMessage('No heroes to display')

  constructor(private heroService: HeroService) { }

  ngOnInit(): void {
    console.log("hello!")
    this.findAllHeroes();
  }

  public findAllHeroes(): void {
    // this method will set the property of this component class to an
    // array that subscribes to a Hero[] observable 
    this.heroService.findAllHeroes()
      .subscribe(
        data => this.heroes = data,
        error => this.clientMessage.message = 'Something went wrong.'
      );
  }

}
