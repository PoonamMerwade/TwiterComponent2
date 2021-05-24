import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../api.respone';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  baseUrl="http://localhost:9090"
  constructor(private http : HttpClient) { }

  login(loginPayload: any) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${this.baseUrl}/user/login`, loginPayload);
  }
}
