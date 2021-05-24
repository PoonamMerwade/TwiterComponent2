import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tweet } from '../model/tweet';

@Injectable({
  providedIn: 'root'
})
export class TweetServiceService {
  likeComment(tweet:any) {
    return this.httpClient.post("http://localhost:9090/tweets/like",tweet)
  }
  
  baseUrl = "http://localhost:9090/tweets"
  // baseUrl1 = "http://localhost:9090/tweets/allTweets"

  username=window.localStorage.getItem('username');

  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<Tweet[]> {
    return this.httpClient.get<Tweet[]>(this.baseUrl + '/allTweets');
  }

  getAllTweets()
  {
    return this.httpClient.get("http://localhost:9090/tweets/allTweets/?username="+localStorage.getItem('username'));
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
  return this.httpClient.post("http://localhost:9090/tweets/replyTweet",user);
}


}