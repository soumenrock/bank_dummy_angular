import { Component, OnInit } from '@angular/core';
import { RegisterFormService } from '../register-form.service';
import { User } from '../data-model';
import {Router} from "@angular/router";
import { constants } from 'os';
import { variable } from '@angular/compiler/src/output/output_ast';
@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  public user:User=new User();
  public userData:User=new User();
  constructor(private service:RegisterFormService,private router:Router) { }
  

  ngOnInit() {
  }
  loginUser(e)
  {
    console.log(this.loginUser);
   this.service.loginUser(this.user).subscribe(
     data => {
        this.userData= data;
        if(this.userData==null || this.userData===null || typeof this.userData==='undefined')
  //  Object.keys(this.userData).length > 0)
   {
     console.log(this.userData);
     this.router.navigate(['/home']);
   }
   else
   {
     console.log(this.userData);
     this.router.navigate(['/user_home']);
   }
     }, error => {
       console.log(error);
     }
   );
   
  }
  
  //userData I want to get at other place
  

}
