# Angular

#### What's a framework?
a framework is a simplification of a language and/or design pattern to a foundation for developers to use to build apps with ease.

## What's Angular?
- It is an open-source TypScript-based frontend framework developed by Google (in 2010).
- It uses a component structure that represents a view on a webpage
- We use Angular to create SPA's (Single Page Applications)
    - SPA's allow for faster and more responsive web pages and a better user-experience

### History of Angular
- Created in 2010 as AngularJS
- Then in 2016 it was rewritten to support TypeScript and Angular 2 was released
- About every 6 months a new version of Angular is released
- We will use Angular 11.

### What makes an Angular app?
- **TypeScript** framework developed and maintained by Google.
- Reusbale code through the inclusion of **modules**
- Dynamics views through the usage of **components** and **templates**
- DOM manipulation is handled through **Directives**
- Single-page applications are created through the use of **Routing**
- Handle **Dependency Injection** through the use of **Services**

## TypeScript
- it is open-source and inveted by Microsoft
- it is a super-set of JS
- it is **strictly typed**
- Browsers themselves cannot interpret TS, so it must be **transpiled into JS**.
    > This is done with the TypeScropt compiler (tsc).
- It has syntax closer to higher level languages like Java, therfore it gives us compilation errors.

## Node JS
- It is a JS interpreter/server environment that allows us to run JS outside of the browser.

### What is NPM?
- Node Package Manager
- It is included in the download of Node.js and consists of a CLI (Command Line Interface) that interacts with a remote registry
- Similar to maven, it can manage dependencies and versions
    - This is done through the `package.json` file (which acts like the `pom.xml`).

### Angular CLI (Command Line Interface)
- This is the CLI that is used to scaffold and build the Angular Project using modules
- `ng` is the Angular command for the CLI
- to install Angualar, we call `npm install -g @angular/cli`

## Angular Components
Components are the most basic block of an Angular app.  An Angular App contains a tree of Angular Components
- Components are essentially classes that interact with the .html file of the component which gets displayed to a browser
- The file structure of a component consists of the following:
    1. mycmp.component.css -- Private styling sheet
    2. mycmp.component.html -- HTML Template
    3. mycmp.component.ts -- Here we define the module, its properties, lifehooks, etc.
    4. mycmp.component.spec.ts -- unit testing file

- To create a component run: `ng g c mycomponent`
- As soon as we create a component, all changes are added to our `app.module.ts` file
- As soon as the component is created, ngOnInit method is created
    - this method is called by default when the class is executed.
- It also has a constructor
- the `app` component is the **Parent component** and any new components that we create and the **Child components**

### Interpolation
- Interpolation allows you to incorporate proerties and embed them into an HTML file with {{}};

## Data-Binding
- Data binding is a technique to link your data to your view layer.
- By binding a variable, you are telling the framework (in this case, Angular) to watch it for changes.
    - If changes are detected, the framework will update the view.

#### One-Way Binding 
- One-way binding will bind the data from the component to the view (DOM) or from the view to the component.
- This is unidirectional (we change one thing)
- **For example**: *Interpolation Binding* -> Interpolation refers to binding expressiong into marked up language (we turned the property of the `app component` into HTML text (as the title like so `{{title}}`))
- **Class Binding** Class binding is used to set a class property of a view element

#### Two-Way Data Binding
- 2-way data binding in Angular will help users to exchange data from the component to view, and from view to component (bidirectional)
- 2-way databinding is a combo of Property Binding and Event Binding
- 2-way binding can be achieved with the `[(ngModel)]` directive...think banana in a box!

## package.json
- Think of the pom.xml file within your Angular project
- The package.json file is stored in the root of your application
- This file is used to give information to npm (node package manager) and identify all the project's dependencies and handle them.

## Webpack
- The angular CLI uses a tool called **webpack** which is a build automation tool.
- it minifies all of our JS scripts, HTML and CSS files and bundles them together
- The webpack traverses our application looking for `import` statements and builds a dependency graph

## Directives
Directives change the appearence behavior or layout of the DOM (Document Object Model)

#### Structural Directives
- These change the DOM layout by adding/removing DOm elements
- `ngFor` and `ngIf`

#### Attribute Directives
- These change the appearence or *behavior* of a particular element, component, or another directive.
- We typically build these ourselves

### @Decorators
*These are similar to the purpose of annotations in Java*
- The **@Component** decorator tells Angular that we want a class to be treated as a component
    - It provides the metadata for how this particular Component Class should be processed, used, and instantiated.




