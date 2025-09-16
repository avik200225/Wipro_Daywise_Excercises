// import { Component, OnInit } from '@angular/core';
// import { CommonModule, KeyValuePipe } from '@angular/common';
// import { OrderService } from '../../services/order-service';

// type OrderStatus = 'PENDING' | 'COMPLETED' | 'CANCELLED';

// @Component({
//   selector: 'app-order-history',
//   standalone: true,
//   imports: [CommonModule, KeyValuePipe], // removed CurrencyPipe, DatePipe (not used)
//   templateUrl: './order-history.html',
//   styleUrls: ['./order-history.css']
// })
// export class OrderHistoryComponent implements OnInit {
//   userId = Number(localStorage.getItem('userId') ?? 0);
//   orders: any[] = [];
//   loading = true;
//   error = '';

//   constructor(private orderSvc: OrderService) {}

//   ngOnInit(): void { this.load(); }

//   load(): void {
//     this.loading = true;
//     this.orderSvc.getOrdersByUser(this.userId).subscribe({
//       next: data => { this.orders = data ?? []; this.loading = false; },
//       error: err => { this.error = err?.error?.message ?? 'Failed to fetch orders'; this.loading = false; }
//     });
//   }

//   displayStatus(s: OrderStatus): string {
//     if (s === 'PENDING') return 'PLACED';
//     return s;
//   }

//   canCancel(s: OrderStatus): boolean {
//     return s === 'PENDING' || s === 'COMPLETED';
//     // adjust to your business rule
//   }

//   cancel(orderId: number): void {
//     this.orderSvc.cancelOrder(orderId, this.userId).subscribe({
//       next: () => this.load(),
//       error: err => alert(err?.error?.message ?? 'Cancel failed')
//     });
//   }
// }
