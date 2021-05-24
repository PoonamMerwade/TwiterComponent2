import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { TweetComponent } from './tweet/tweet.component';
// import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { SearchByLoginIdComponent } from './search-by-login-id/search-by-login-id.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { TokenInterceptor } from './interceptor';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { LikeCompComponent } from './like-comp/like-comp.component';
import { MyAccountComponent } from './my-account/my-account.component';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    TweetComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    LogoutComponent,
    SearchByLoginIdComponent,
    ForgotPasswordComponent,
    LikeCompComponent,
    MyAccountComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatProgressSpinnerModule,
    
  ],
  providers:[{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi:true
  }
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
