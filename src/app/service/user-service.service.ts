import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  
  baseUrl = "http://3.12.147.32:8081/user";
  username=window.localStorage.getItem('username')
  baseUrl1="http://3.12.147.32:8081/user/update"
  baseUrl2="http://3.12.147.32:8081/tweets"
  constructor(private httpClient: HttpClient) { }
  
  public flag = new Subject<any>();

  public setFlag(message: any) {
  this.flag.next(message);
  }  
   public getFlag(): Observable<any> {
  return this.flag.asObservable();
  }

  addUser(user: User): Observable<User> {
    return this.httpClient.post<User>(this.baseUrl + "/register", user);
  }
  
  getUserByusername(username: String): Observable<User> {
    return this.httpClient.get<User>(`${this.baseUrl}+"/search"+/${username}`);
  }

  updatePassword(username: string,user:User): Observable<any> {
    // this.username=window.localStorage.getItem('username');
    return this.httpClient.patch<any>(`${this.baseUrl1}/${username}`,user);
  }

  updateUserByusername(user:User): Observable<User>{
    return this.httpClient.put<User>(this.baseUrl+"/update", user);
  }

    getAll(): Observable<User[]> {
      return this.httpClient.get<User[]>(this.baseUrl + '/allUsers');
    }
    
    getAllTweets()
  {
    return this.httpClient.get("http://3.12.147.32:8081/user/allTweets/?username="+localStorage.getItem('username'));
  }

  deleteTweet(index:any)
  {
    return this.httpClient.delete("http://3.12.147.32:8081/tweets/delete/?tweetId="+index);
  }
  
  
}