import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserInterface } from '../interface/user-interface';
import { Observable } from 'rxjs';
import { Token } from '../interface/token';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
 private baseUrl = 'http://localhost:8080/user'; 

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<Token> {
    return this.http.post<Token>(`${this.baseUrl}/login`, { email, passWord: password });
  }

  logout(userId: number): Observable<any> {
  return this.http.post(`${this.baseUrl}/logout/${userId}`, {});
}

}