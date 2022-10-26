import { NgModule } from '@angular/core';
import { FormControl, FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { from } from 'rxjs';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FistComponentComponent } from './fist-component/fist-component.component';

@NgModule({
  declarations: [
    AppComponent,
    FistComponentComponent
  ],
  imports: [
    BrowserModule, FormsModule,
    AppRoutingModule, 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
