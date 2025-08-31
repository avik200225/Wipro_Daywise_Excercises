import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { finalize } from 'rxjs/operators';
import { UserLoginService } from '../../services/user-login-service';
import { Token } from '../../interface/token';

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
      alert(this.error); 
      return;
    }

    this.loading = true;

    this.api.login(this.email, this.password)
      .pipe(finalize(() => { this.loading = false; }))
      .subscribe({
        next: (res: Token) => {
          const token = res?.token || (res as any);

          if (!token || typeof token !== 'string' || !token.includes('.')) {
            const msg = 'Login unsuccessful: user id or password is wrong.';
            this.error = msg;
            alert(msg);
            return;
          }

          localStorage.setItem('jwt', token);
          localStorage.setItem('username', this.email);

          try {
            const payload = JSON.parse(atob(token.split('.')[1]));
            const roles: string[] = payload?.authorities || [];
            if (roles.includes('ROLE_ADMIN')) this.router.navigate(['/admin']);
            else this.router.navigate(['/catalog']);
          } catch {

            const msg = 'Login unsuccessful: user id or password is wrong.';
            this.error = msg;
            alert(msg);
          }
        },
        error: (err) => {

          if (err?.status === 401) {
            const msg = 'Login unsuccessful: user id or password is wrong.';
            this.error = msg;
            alert(msg);
          } else {
            this.error = 'Login failed. Please try again.';
            alert(this.error);
          }
        }
      });
  }

  goToRegistration() {
    this.router.navigate(['/register']);
  }
}
