import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AuthGuard } from './auth.guard';
import { RegisterComponent } from './register/register.component';
import { AddbookComponent } from './components/addbook/addbook.component';


const routes: Routes = [
{
path:'',
component: HomeComponent,
pathMatch:'full'

},
{
  path:'home',
  component: HomeComponent,
  pathMatch:'full'
  
  },

{
  path:'login',
  component: LoginComponent,
  pathMatch:'full'
  
  },
  {
    path:'register',
    component: RegisterComponent,
    pathMatch:'full'
    
    },
  {
    path:'dashboard',
    component: DashboardComponent,
    pathMatch:'full',
    canActivate: [AuthGuard]
    
    },
    {
      path:'addbook',
      component: AddbookComponent,
      pathMatch:'full',
     
      
      }
  


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
