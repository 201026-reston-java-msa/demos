import { Cat } from './../cat';
import { Component, OnInit, Input } from '@angular/core';
import {Location} from '@angular/common';
import {ActivatedRoute} from '@angular/router';
// ActivatedRoute interacts with the route's URL, which we need to do in order to extract the id
import { CatService } from './../cat.service';

// This is essentially a Feature component
// This is a child component (sub-component) of the CatsComponent
@Component({
  selector: 'app-cat-details',
  templateUrl: './cat-details.component.html',
  styleUrls: ['./cat-details.component.css']
})
export class CatDetailsComponent implements OnInit {

  cat: Cat;

  constructor(
    private route: ActivatedRoute,
    private catService: CatService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getCat();
  }

  getCat(): void {
    // grab an ID
    const id = +this.route.snapshot.paramMap.get('id');
    // subscribe to the Service and return the cat by passing the id to the Service's getCat(id) method
    this.catService.getCat(id)
      .subscribe(cat => this.cat = cat);
  }

  goBack(): void {
    this.location.back();
  }

}
