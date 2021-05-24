import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomeComponent } from './home/home.component';
import { LikeCompComponent } from './like-comp/like-comp.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MyAccountComponent } from './my-account/my-account.component';
import { RegisterComponent } from './register/register.component';
import { SearchByLoginIdComponent } from './search-by-login-id/search-by-login-id.component';
import { TweetComponent } from './tweet/tweet.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"add",component:RegisterComponent},
  {path:"",component:HomeComponent},
  {path:"login",component:LoginComponent},
  {path:"user",component:UserComponent},
  {path:"tweet",component:TweetComponent},
  {path:"logout",component:LogoutComponent},
  {path:"search",component:SearchByLoginIdComponent},
  {path:"fp",component:ForgotPasswordComponent},
  {path:"like",component:LikeCompComponent},
  {path:"myaccount",component:MyAccountComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
