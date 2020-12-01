import { CatService } from './../cat.service';
import { Component, OnInit } from '@angular/core';
import { Cat } from '../cat';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  cats: Cat[] = [];

  constructor(private catService: CatService) { }

  ngOnInit(): void {
    this.getCats();
  }

  // This dashboard will show our top 4 cats
  getCats(): void {
    this.catService.getCats()
    .subscribe(cats => this.cats = cats.slice(0, 4));
  }

}
