import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Productservice, Order } from '../productservice';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-orderhistory',
  imports: [CommonModule],
  templateUrl: './orderhistory.html',
  styleUrl: './orderhistory.css'
})
export class Orderhistory implements OnInit {
  orders: Order[] = [];
  isLoading = true;
  errorMessage = '';

  constructor(
    private productService: Productservice,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.loadOrderHistory();
  }

  loadOrderHistory() {
    this.isLoading = true;
    this.errorMessage = '';
    this.productService.getOrderHistory().subscribe({
      next: (data: Order[]) => {
        this.orders = data;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (error) => {
        this.isLoading = false;
        this.errorMessage = 'Failed to load order history. Please try again.';
        console.error('Error fetching order history:', error);
        this.cdr.detectChanges();
      }
    });
  }

  backToList() {
    this.router.navigate(['/productlist']);
  }
}