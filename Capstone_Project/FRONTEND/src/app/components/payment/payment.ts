// import { Component, OnInit } from '@angular/core';
// import { CommonModule, CurrencyPipe, KeyValuePipe } from '@angular/common';
// import { Router } from '@angular/router';
// import { CartService } from '../../services/cart-service';
// import { OrderService } from '../../services/order-service';

// @Component({
//   selector: 'app-payment',
//   standalone: true,
//   imports: [CommonModule, CurrencyPipe, KeyValuePipe],
//   templateUrl: './payment.html',
//   styleUrls: ['./payment.css']
// })
// export class PaymentComponent implements OnInit {
//   userId = Number(localStorage.getItem('userId') ?? 0);
//   cart: any = null;             // { prodDetails: { [productId]: qty }, totalPrice, totalQty }
//   lineItems: Array<{name:string; price:number; qty:number; subtotal:number}> = [];
//   total = 0;

//   constructor(
//     private cartSvc: CartService,
//     private orderSvc: OrderService,
//     private router: Router
//   ) {}

//   ngOnInit(): void {
//     this.fetchCart();
//   }

//   private fetchCart(): void {
//     if (!this.userId) { this.router.navigate(['/login']); return; }
//     this.cartSvc.getCart(this.userId).subscribe(cart => {
//       this.cart = cart;

//       this.total = cart?.totalPrice ?? 0;

//     });
//   }

//   payNow(): void {
//     if (!this.userId) return;
//     this.orderSvc.createOrder({ userId: this.userId }).subscribe({
//       next: () => this.router.navigate(['/orders']),
//       error: err => alert(err?.error?.message ?? 'Payment failed')
//     });
//   }
// }
