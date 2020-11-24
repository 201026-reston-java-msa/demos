# CatWebapp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 11.0.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

### What we've done so far
- We utilized the Angular CLI to create the initial app structure
- We learned that the app component displays our data (as do all components)
- We used double curly braces of interpolation to display the app title property

### What we did next:
- We used the CLI to create a second component (cats) with the command ng g c cats
- We displayed the CatsComponent by adding it to the AppComponent Shell
- We applied an UpperCase Pipe to format the name
- We used two-way databinding with the ngModel directive 
- We touched upon imports in the AppModule
- We imported the FormsModule in the AppModule so that Angular would recognize and apply the ngModel directive
