import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { ChangepasswordComponent } from './components/changepassword/changepassword.component';
import { ForgotpasswordfirstComponent } from './components/forgotpasswordfirst/forgotpasswordfirst.component';
import { ForgotpasswordsecondComponent } from './components/forgotpasswordsecond/forgotpasswordsecond.component';
import { HomeComponent } from './components/home/home.component';
import { InductPatientComponent } from './components/induct-patient/induct-patient.component';
import { LoginComponent } from './components/login/login.component';
import { ProcessComponent } from './components/process/process.component';
import { UpdateComponent } from './components/update/update.component';
import { ViewUpdateComponent } from './components/view-update/view-update.component';
import { AuthgurdGuard } from './services/authgurd.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full',
    canActivate: [AuthgurdGuard]
  },
  {
    path: 'about',
    component: AboutComponent,
    pathMatch: 'full',
  },
  {
    path: 'induct',
    component: InductPatientComponent,
    pathMatch: 'full',
  },
  
  {
    path: 'updatePatient',
    component: UpdateComponent,
    pathMatch: 'full',
  },
  {
    path: 'viewAndUpdate/:flowname',
    component: ViewUpdateComponent,
    pathMatch: 'full',
  },
  {
    path: 'process',
    component: ProcessComponent,
    pathMatch: 'full',
  },
  {
    path: 'changePassword',
    component: ChangepasswordComponent,
    pathMatch: 'full'
  },
  {
    path: 'forgotpassword',
    component: ForgotpasswordfirstComponent,
    pathMatch: 'full'
  },
  {
    path: 'verifyOTP',
    component: ForgotpasswordsecondComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
