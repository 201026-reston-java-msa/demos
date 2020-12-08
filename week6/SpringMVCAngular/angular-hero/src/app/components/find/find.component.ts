import { ClientMessage } from './../../models/client-message.model';
import { Hero } from './../../models/hero.model';
import { HeroService } from './../../services/hero.service';
import { Component, OnInit } from '@angular/core';
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent {

  title = 'Find Hero';

  // Capture User input
  public hero: Hero = new Hero(0, '', '', false);

  // Present recieved Hero
  public heroData: Hero = new Hero(0, '', '', false);
  
  // Message to the User
  public clientMessage: ClientMessage = new ClientMessage('');

  constructor(private heroService: HeroService) { }

  public findHero(): void {
    this.heroService.findHero(this.hero)
    .subscribe(
      data => this.heroData = data,
      error => this.clientMessage.message = 'SOMETHING WENT WRONG.'
    )
  }

}
