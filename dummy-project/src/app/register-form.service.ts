import { Injectable } from '@angular/core';

  import { HttpClient } from '@angular/common/http';
import { User } from './data-model';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class RegisterFormService {
public _url: string=" http://localhost:11000/jovin/fetchUser";
  constructor(private http:HttpClient) { 
 
  }


  addUser(user:User):Observable<User>
  {
    // console.log(user);
    
    let url="http://localhost:11000/jovin/createUser";
    return this.http.post<User>(url,JSON.stringify(user),{headers:{'Content-Type':'application/json'}});
  }

  loginUser(user:User):Observable<User>
  {
    console.log(user);
    let url="http://localhost:11000/jovin/loginUser"
    return this.http.post<User>(url,JSON.stringify(user),{headers:{'Content-Type':'application/json'}});
  }

  fetchUser(user:User):Observable<User>
  {
    return this.http.post<User>(this._url,JSON.stringify(user),{headers:{'Content-Type':'application/json'}});
  }

  

}
