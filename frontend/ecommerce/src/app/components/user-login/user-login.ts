import { Component } from '@angular/core';
import { UserLoginService } from '../../services/user-login-service';
import { Router } from '@angular/router';
import { Token } from '../../interface/token';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './user-login.html',
  styleUrls: ['./user-login.css']
})
export class UserLogin {
  email = '';
  password = '';
  loading = false;
  error = '';

  constructor(private api: UserLoginService, private router: Router) {}

  onLogin() {
    this.error = '';
    if (!this.email || !this.password) {
      this.error = 'Email and password are required';
      return;
    }
    this.loading = true;
    this.api.login(this.email, this.password).subscribe({
      next: (res: Token) => {
        const token = res?.token || (res as any);
        localStorage.setItem('jwt', token);
        localStorage.setItem('username', this.email);
        this.loading = false;

        try {
          const payload = JSON.parse(atob(token.split('.')[1] || '')) || {};
          const roles: string[] = payload?.authorities || [];
          if (roles.includes('ROLE_ADMIN')) this.router.navigate(['/admin']);
          else this.router.navigate(['/catalog']);
        } catch {
          this.router.navigate(['/catalog']);
        }
      },
      error: (err) => {
        this.loading = false;
        this.error = 'Login failed';
      }
    });
  }

  goToRegistration(){
     this.router.navigate(['/register']);
     }
}
