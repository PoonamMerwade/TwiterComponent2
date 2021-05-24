import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  user:User=new User();
  errMsg!: string;
  isNew!: boolean;
  success=false;
  // users!:User[];
  username=this.actRoute.snapshot.params.username;

  constructor(
    private Service:UserServiceService,
    private actRoute:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit() {
    // let username = this.actRoute.snapshot.params.username;
    this.username=window.localStorage.getItem('username');
    if(this.username){
      this.isNew = false;
      this.Service.getUserByusername(this.username).subscribe(
        (data: User)=>{
          this.user=data;
        }
      );
    }else{
      this.isNew = true;
      this.user = {
        "username":window.localStorage.getItem('username'),
        "email":this.user.email,
        "firstName":this.user.firstName,
        "lastName":this.user.lastName,
        "password":"",
        "confirmPassword":"",
        "contactNumber":this.user.contactNumber,
        }
    }
   
  }
  forgotPassword(){
    let ob: Observable<User>;
    let username =window.localStorage.getItem('username');
    ob = this.Service.updatePassword(this.user.username,this.user);
    ob.subscribe(
      (data)=>{
        alert('PASSWORD UPDATED SUCCESSFULLY....');
        this.router.navigateByUrl("/login");
      },
      (errResponse)=>{
        this.errMsg = errResponse.error;
      }
    );

  }
  
}


 //