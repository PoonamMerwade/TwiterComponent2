import { Component, OnInit } from '@angular/core';
import { Tweet } from '../model/tweet';
import { TweetServiceService } from '../service/tweet-service.service';

@Component({
  selector: 'app-search-by-login-id',
  templateUrl: './search-by-login-id.component.html',
  styleUrls: ['./search-by-login-id.component.css']
})
export class SearchByLoginIdComponent implements OnInit {

  errMsg!: string;
  list: any;
  username!: string;
  tweets!: Tweet[];
  // tweet!:Tweet;
  tweet:any;
  
  constructor(private Service: TweetServiceService) { }

  ngOnInit(){
   
  }

  public findTweetsByUsername() {
    this.Service. getTweetByUsername(this.username).subscribe(response => {
      this.tweet=response;
    
  });
}
}
