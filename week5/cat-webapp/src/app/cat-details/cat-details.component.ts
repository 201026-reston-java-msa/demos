import { Cat } from './../cat';
import { Component, OnInit, Input } from '@angular/core';
// This is essentially a Feature component
// This is a child component (sub-component) of the CatsComponent
@Component({
  selector: 'app-cat-details',
  templateUrl: './cat-details.component.html',
  styleUrls: ['./cat-details.component.css']
})
export class CatDetailsComponent implements OnInit {

  @Input() cat: Cat; 

  constructor() { }

  ngOnInit(): void {
  }

}
