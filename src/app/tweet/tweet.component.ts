import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Tweet } from '../model/tweet';
import { TweetServiceService } from '../service/tweet-service.service';

@Component({
  selector: 'app-tweet',
  templateUrl: './tweet.component.html',
  styleUrls: ['./tweet.component.css']
})
export class TweetComponent implements OnInit {
  //likeArray: any;
  likeArray: Array<boolean> = [];
  replyDesc: String;
  reply: Array<boolean>=[];
  
  constructor(private tweetService: TweetServiceService, private router: Router) {
    this.replyDesc='';
   }
  tweets!: any;
  date!:Date
  posttweetsform: any;
  ls!:string;

  ngOnInit(): void {
    // this.likeArray=false;
     window.localStorage.getItem('username');
    this.tweetService.getAll().subscribe(response => {
       this.tweets = response;
      this.tweets.forEach((tweet: any) => {
        const username = window.localStorage.getItem('username');
        var date1 = new Date(tweet.date).getTime();
        var date2 = new Date().getTime();
        var msec = date2 - date1;
        var mins = Math.floor(msec / 60000);
        var hrs = Math.floor(mins / 60);
        var days = Math.floor(hrs / 24);
        var yrs = Math.floor(days / 365);
        if(mins<60)
        {
          tweet.date=mins+' mins ago';
        }
        else if(mins>60 && hrs<=24)
        {
            tweet.date=hrs+' hours ago';
        }
        else{
          tweet.date=days+' days ago';
        }
        this.likeArray.push(false);
        this.reply.push(false);
        this.replyDesc='';
        
      });
    })
    this.posttweetsform = new FormGroup({
      'username': new FormControl(localStorage.getItem('username'),),
      'tweetDesc': new FormControl('',)
    })
  }

 

  posttweet(posttweetsform: any) {
    console.log(posttweetsform);
    this.tweetService.postTweet(posttweetsform.value).subscribe((response: any) => {
      console.log(response)
    }, (error) => {
      console.log(error);
      this.ngOnInit();
    })
  }

  like(index: any) {
    this.likeArray[index] = true;
  }

  unlike(index: any) {
    this.likeArray[index] = false;
  }
 
  postcomment(index:any,i:any){
    const request= ({
      username:localStorage.getItem('username'),
      tweetId:index,
      replyDesc:this.replyDesc
    });
    this.tweetService.postComment(request).subscribe((response: any)=>{
      console.log(response);
    }, (error) => {
      console.log(error);
      this.ngOnInit();
      this.reply[i]=false;
    })
    console.log(index);
  }
}

  

 

