import { CatDetailsComponent } from './cat-details/cat-details.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CatsComponent } from './cats/cats.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'cats', component: CatsComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
    // This route redirects a URL that fully matches the empty path to the route whose path is '/dashboard'
  { path: 'detail/:id', component: CatDetailsComponent}
];

// /cats --> I want you to load my CatsComponent
// /details/id --> I want you to load the details of that particular cat...

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
