import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInterface } from '../interface/user-interface';

@Injectable({ providedIn: 'root' })
export class UserRegistrationnService {
  private baseUrl = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {}

  registerUser(payload: UserInterface): Observable<string> {
    return this.http.post(`${this.baseUrl}/saveuser`, payload, { responseType: 'text' });
  }
}
