import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInterface } from '../interface/user-interface';

@Injectable({ providedIn: 'root' })
export class UserRegistrationnService {
  private baseUrl = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {}

  registerUser(user: UserInterface): Observable<string> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(`${this.baseUrl}/saveuser`, user, {
      headers,
      responseType: 'text',
    });
  }
}
