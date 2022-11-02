import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductsComponent } from './add-products/add-products.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ViewProductsComponent } from './view-products/view-products.component';
import { ViewsingleproductComponent } from './viewsingleproduct/viewsingleproduct.component';

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
      path:'register',
      component: SignupComponent,
      pathMatch:'full'
      
      },
  {
    path:'login',
    component: UserLoginComponent,
    pathMatch:'full'
    
    },
    {
      path:'viewSingleProduct/:id',
      component: ViewsingleproductComponent
      
      },
      {
        path:'addProduct/:id',
        component: AddProductsComponent
        
        },
      
      {
        path:'addProduct',
        component: AddProductsComponent,
        pathMatch:'full'
        
        },
        {
          path:'viewProducts',
          component: ViewProductsComponent,
          pathMatch:'full'
          
          },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
