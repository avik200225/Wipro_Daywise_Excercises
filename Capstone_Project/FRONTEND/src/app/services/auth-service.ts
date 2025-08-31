import { Injectable } from '@angular/core';
import { JwtPayload } from '../interface/jwt-payload';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
decodeToken(token: string): JwtPayload {
    const payload = token.split('.')[1];
    return JSON.parse(atob(payload));
  }

  isAdmin(): boolean {
    const token = localStorage.getItem('jwt');
    if (!token) return false;
    const decoded = this.decodeToken(token.replace('Bearer ', ''));
    return decoded.authorities?.includes('ROLE_ADMIN') ?? false;
  }

  isUser(): boolean {
    const token = localStorage.getItem('jwt');
    if (!token) return false;
    const decoded = this.decodeToken(token.replace('Bearer ', ''));
    return decoded.authorities?.includes('ROLE_USER') ?? false;
  }

  getUserId(): number | null {
    const token = localStorage.getItem('jwt');
    if (!token) return null;
    const decoded = this.decodeToken(token.replace('Bearer ', ''));
    return Number(decoded.sub);
  }
}