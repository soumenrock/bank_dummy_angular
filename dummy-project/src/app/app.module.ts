import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { BankComponent } from './bank/bank.component';

import { FormsModule } from '@angular/forms';
import { RegisterFormComponent } from './register-form/register-form.component';
import { HttpClientModule } from '@angular/common/http';
import { RegisterFormService } from './register-form.service';
import { UserLoginComponent } from './user-login/user-login.component';

import { HomeComponent } from './home/home.component';

import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';



const routes: Routes=[
  {path:'Register', component:RegisterFormComponent},
  {path:'home', component:HomeComponent},
  {path:'login', component:UserLoginComponent},
  {path:'user_home', component:DashboardComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    BankComponent,
    RegisterFormComponent,
    UserLoginComponent,
   
    HomeComponent,
   
    DashboardComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  exports : [RouterModule],
  providers: [RegisterFormService],
  bootstrap: [AppComponent]
})
export class AppModule { }
export const routingComponent= [RegisterFormComponent,BankComponent,UserLoginComponent,DashboardComponent]
