import { Component, OnInit } from '@angular/core';
import { User } from '../data-model';
import { RegisterFormService } from '../register-form.service';


@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  public user:User=new User();
  
  constructor(private service:RegisterFormService) { 

  }

  ngOnInit() {
  }
 onSubmit()
 {
   this.service.addUser(this.user).subscribe();
 }
}
