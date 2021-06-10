import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tweet } from '../model/tweet';

@Injectable({
  providedIn: 'root'
})
export class TweetServiceService {
  likeComment(tweet:any) {
    return this.httpClient.post("http://3.12.147.32:8081/tweets/like",tweet)
  }
  
  baseUrl = "http://3.12.147.32:8081/tweets"
  // baseUrl1 = "http://3.12.147.32:8081/tweets/allTweets"

  username=window.localStorage.getItem('username');

  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Tweet[]> {
    return this.httpClient.get<Tweet[]>(this.baseUrl + '/allTweets');
  }

  getAllTweets()
  {
    return this.httpClient.get("http://3.12.147.32:8081/tweets/allTweets/?username="+localStorage.getItem('username'));
  }

 getTweetByUsername(username:string): Observable<Tweet[]>{
  return this.httpClient.get<Tweet[]>(this.baseUrl+"/TweetsbyUser/"+username);
 }

 postTweet(tweet: Tweet): Observable<Tweet> {
  return this.httpClient.post<Tweet>(this.baseUrl + "/post", tweet);
}

updateTweet(tweet:Tweet): Observable<Tweet>{
  return this.httpClient.put<Tweet>(this.baseUrl+"/update", tweet);
}

postComment(user:any){
  return this.httpClient.post("http://3.12.147.32:8081/tweets/replyTweet",user);
}


}