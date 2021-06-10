import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../api.respone';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  baseUrl="http://3.12.147.32:8081"
  constructor(private http : HttpClient) { }

  login(loginPayload: any) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${this.baseUrl}/user/login`, loginPayload);
  }
}
