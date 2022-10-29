import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddcourseComponent } from './addcourse/addcourse.component';

import {CourselistComponent } from './courselist/courselist.component';
import { ViewcourseComponent } from './viewcourse/viewcourse.component';


const routes: Routes=[
{path: '', component: CourselistComponent},
{path: 'addcourse', component: AddcourseComponent},
{path: 'courselist', component: CourselistComponent},
{path: 'viewcourse', component: ViewcourseComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}