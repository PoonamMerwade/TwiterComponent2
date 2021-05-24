import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  // public users: User[] = [];
  // user: User = new User;

  users:any;
  constructor(private userService: UserServiceService,private route: Router) { }

  ngOnInit(){
    this.userService.getAll().subscribe(data=>this.users=data);
   
  }

}
