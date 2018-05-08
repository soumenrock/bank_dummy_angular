import { Component, OnInit } from '@angular/core';
import { User } from '../data-model';
import { RegisterFormService } from '../register-form.service';
import { UserLoginComponent } from '../user-login/user-login.component';



@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public userdetails:User;
  constructor(private user_service:RegisterFormService) { }

  ngOnInit() {
    //here I want to get that variable value
    this.user_service.fetchUser().subscribe(data =>this.userdetails = data); 
  }

}
