import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TweetServiceService } from '../service/tweet-service.service';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {
  

  constructor(private userService: UserServiceService, private router: Router) { }
  tweet:any;
  ngOnInit(): void {
    this.userService.getAllTweets().subscribe(response => {
      this.tweet=response;
  })

  }

  delete(index:any)
  {
    // const tweetId=index;
    this.userService.deleteTweet(index).subscribe(response =>{
      
    },(error)=>{
      this.ngOnInit();
    }
      );
  }
  
}
