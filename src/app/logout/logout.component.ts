import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private route : Router) { }

  ngOnInit(): void {
    window.localStorage.removeItem('token');
    window.localStorage.removeItem('username');
    alert('logged out....');
    this.route.navigate(['login']);
  }

}
