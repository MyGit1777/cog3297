import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';

import {MatRadioModule} from '@angular/material/radio';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { HomeComponent } from './components/home/home.component';
import { InductPatientComponent } from './components/induct-patient/induct-patient.component';
import { ViewUpdateComponent } from './components/view-update/view-update.component';
import { ProcessComponent } from './components/process/process.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthModifier } from './services/auth.modifier';
import { LoginServiceService } from './services/login-service.service';
import { AboutComponent } from './components/about/about.component';
import { ForgotpasswordfirstComponent } from './components/forgotpasswordfirst/forgotpasswordfirst.component';
import { ForgotpasswordsecondComponent } from './components/forgotpasswordsecond/forgotpasswordsecond.component';
import { ChangepasswordComponent } from './components/changepassword/changepassword.component';
import {MatTabsModule} from '@angular/material/tabs';
// import {MatFileUploadModule} from './components/file-upload/file-upload.core';

@NgModule({
  declarations: [
    AppComponent,
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    InductPatientComponent,
    ViewUpdateComponent,
    ProcessComponent,
    RegisterComponent,
    AboutComponent,
    ForgotpasswordfirstComponent,
    ForgotpasswordsecondComponent,
    ChangepasswordComponent,
     ],
    providers: [LoginServiceService, AuthModifier, [{provide:HTTP_INTERCEPTORS, useClass:AuthModifier, multi:true}]],
     bootstrap: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    HttpClientModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatIconModule,
    MatTabsModule,
    // MatFileUploadModule
  ]})
export class AppModule { }
