
import { Component } from '@angular/core';
import { UserRegistrationnService } from '../../services/user-registration-service';
import { Router } from '@angular/router';
import { UserInterface } from '../../interface/user-interface';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-registration',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './user-registration.html',
  styleUrls: ['./user-registration.css']
})
export class UserRegistration {
  user: UserInterface = {
    firstname: '',
    lastName: '',
    email: '',
    passWord: '',
    address: ''
  };

  loading = false;
  error = '';

  constructor(private userService: UserRegistrationnService, private router: Router) {}

  onRegister() {
    this.error = '';
    if (!this.user.email || !this.user.passWord || !this.user.firstname || !this.user.lastName) {
      alert('Please fill all required fields.');
      return;
    }

    this.loading = true;

    this.userService.registerUser(this.user).subscribe({
      next: (msg: string) => {
        this.loading = false;


        if (typeof msg === 'string' && msg.toUpperCase().includes('SUCCESS')) {
          alert('User registered successfully');
          this.router.navigate(['/demo']); 
        } else {

          alert(msg || 'Registration completed.');
        }
      },
      error: (err) => {
        this.loading = false;

        if (err?.status === 409) {
          alert('Email already exists. Please login or use a different email.');
        } else {
          alert('Registration failed (USER ALREADY REGISTERED). Please try again.');
        }
      }
    });
  }
}
