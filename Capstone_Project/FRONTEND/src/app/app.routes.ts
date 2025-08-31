import { Routes } from '@angular/router';
import { UserLogin } from './components/user-login/user-login';
import { UserRegistration } from './components/user-registration/user-registration';
import { AdminDashboard } from './components/admin-dashboard/admin-dashboard';
import { UserDashboard } from './components/user-dashboard/user-dashboard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', loadComponent: () => Promise.resolve(UserLogin) },
  { path: 'register', loadComponent: () => Promise.resolve(UserRegistration) },
  { path: 'admin', loadComponent: () => Promise.resolve(AdminDashboard) },
  { path: 'catalog', loadComponent: () => Promise.resolve(UserDashboard) },
  { path: 'cart', loadComponent: () => import('./components/cart/cart').then(m => m.CartPage) }  
];
