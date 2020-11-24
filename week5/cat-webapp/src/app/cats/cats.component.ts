import { Component, OnInit } from '@angular/core';
// We must import the Cat interface inorder to set it as a property
import { Cat } from '../cat';

// The CLI generated 3 important metadata properties
@Component({
  selector: 'app-cats', // the component's element selector
  templateUrl: './cats.component.html', // This is the location of our HTML template
  styleUrls: ['./cats.component.css'] // location of our private CSS styles
})
export class CatsComponent implements OnInit {

  cat: Cat = {
    id: 1,
    name: 'Winston'
  }

  constructor() { }

  // This is a lifecycle hook
  // Ng calls nG onInit() shortly after creating a component
  // we put initailization logic in here...
  ngOnInit(): void {
  }

}
