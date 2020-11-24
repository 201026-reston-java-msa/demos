import { Component } from '@angular/core';

// The @ sign denotes a Decorator
// The @Component decorator provides configuration metadata for how the
// class should be processed/instantiated, and used at runtime.
@Component({
  selector: 'app-root', // this is how we select/reference this particular component
  templateUrl: './app.component.html', // this links to our HTML template
  styleUrls: ['./app.component.css'] // this links to our styles pages 
})
export class AppComponent {
  // this is the title property of my AppComponent
  // I've changed the title property to my AppComponent
  title = 'All About Cats';
}
