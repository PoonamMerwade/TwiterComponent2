import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user!: User;
  errMsg!: string;
  isNew!: boolean;
  success=false;
  // ob: User = new User;
  constructor(
    private Service:UserServiceService,
    private actRoute:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit() {
    let username = this.actRoute.snapshot.params.username;
    if(username){
      this.isNew = false;
      this.Service.getUserByusername(username).subscribe(
        (data: User)=>{
          this.user=data;
        }
      );
    }else{
      this.isNew = true;
      this.user = {
        "username":"",
        "email":"",
        "firstName":"",
        "lastName":"",
        "password":"",
        "confirmPassword":"",
        "contactNumber":"",
        }
    }
  }
  save(){
    let ob: Observable<User>;
    if(this.isNew){
      ob = this.Service.addUser(this.user);
    }else{
      ob = this.Service.updateUserByusername(this.user);
    }
    ob.subscribe(
      (data)=>{
        alert('USER DETAILS ADDED SUCCESSFULLY....');
        this.router.navigateByUrl("/tweet");
      },
      (errResponse)=>{
        this.errMsg = errResponse.error;
      }
    );
}
  }