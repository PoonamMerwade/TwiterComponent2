import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
import { User } from '../model/user';
// import { AuthService } from '../service/auth.service';
// import { AuthenticationService } from '../service/authentication.service';
import { LoginServiceService } from '../service/login-service.service';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  invalidLogin: boolean = false;
  showSpinner: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router,private Service:UserServiceService, private loginService: LoginServiceService,private actRoute:ActivatedRoute) { }
  userForm: any;
  user:User=new User();
  errMsg!: string;
  isNew!: boolean;
  success=false;
  // users!:User[];
  username=this.actRoute.snapshot.params.username;
  
  ngOnInit(): void {
    window.localStorage.removeItem('token');
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
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

  onSubmit() {
    if (this.loginForm.invalid) {
      return ;
    }
    const loginPayload = {
      username: this.loginForm.controls.username.value,
      password: this.loginForm.controls.password.value

    }
    this.loginService.login(loginPayload).subscribe(data => {
      //debugger;
      if (data.status === 200) {
        window.localStorage.setItem('token', data.result.token);
        window.localStorage.setItem('username', data.result.username);
        if (this.invalidLogin = false) {
          this.showSpinner = true;
          setTimeout(() => {
            this.showSpinner = false;
          }, 100);
        }
        this.router.navigateByUrl("/tweet");
        this.Service.setFlag(true);
      } else {
        this.invalidLogin = true;
        alert(data.message);
      }
    })
  }


  onLoadData() {
    this.showSpinner = true;
    setTimeout(() => {
      this.showSpinner = false;
    }, 50000);
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
