import { Routes, RouterModule } from '@angular/router';

import { UserRegistrationComponent } from './user-registration/user-registration.component';

const routes: Routes = [
   
    { path: 'register', component: UserRegistrationComponent },

    
];

export const appRoutingModule = RouterModule.forRoot(routes);