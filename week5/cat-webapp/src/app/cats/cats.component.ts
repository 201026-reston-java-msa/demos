import { MessageService } from './../message.service';
import { CatService } from './../cat.service';
import { Cat } from './../cat';
import { CATS } from './../mock-cats';
import { Component, OnInit } from '@angular/core';

// We must import the Cat interface inorder to set it as a property

// The CLI generated 3 important metadata properties
@Component({
  selector: 'app-cats', // the component's element selector
  templateUrl: './cats.component.html', // This is the location of our HTML template
  styleUrls: ['./cats.component.css'] // location of our private CSS styles
})
export class CatsComponent implements OnInit {

  cats: Cat[]; // this property is assigned thanks to our getCats() method ngOnInit
  // selectedCat: Cat; // this property is not assigned a value when we inititalize...

  // we will expose this array for binding 

  constructor(private catService: CatService, private messageService: MessageService) { }

  // This is a lifecycle hook
  // Ng calls nG onInit() shortly after creating a component
  // we put initailization logic in here...
  ngOnInit(): void {
    this.getCats();
  }

  // onSelect(cat: Cat): void {
  //   this.selectedCat = cat;
  //   this.messageService.add(`CatsComponent: Selected cat id=${cat.id}`);
  // }

  // This is synchronous
  // getCats(): void {
  //   this.cats = this.catService.getCats();
  // }

  getCats(): void {
    this.catService.getCats()
    .subscribe(cats => this.cats = cats);
  }
  // The subscribe method is going to pass the emitted array
  // to the callback which assigns this array as a property 
  //of our component

  add(name: string): void {
    name = name.trim();
    if (!name) {return;}

    this.catService.addCat({ name } as Cat)
      .subscribe(cat => {
        this.cats.push(cat);
      })
  }

  delete(cat: Cat): void {
    this.cats = this.cats.filter(c => c !== cat);  // this is so the component maintains its own
  
    // If you DON'T subscribe, then the service will
    // not send the delete request to the server
    this.catService.deleteCat(cat).subscribe();
  }
}


