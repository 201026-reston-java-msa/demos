import { MainComponent } from './components/main/main.component';
import { AllComponent } from './components/all/all.component';
import { FindComponent } from './components/find/find.component';
import { RegisterComponent } from './components/register/register.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: 'main', component: MainComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'find', component: FindComponent},
  { path: 'all', component: AllComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
