import { Component, OnInit } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { Router } from '@angular/router';
import { CartService, CartItem } from '../../services/cart-service';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, CurrencyPipe],
  templateUrl: './cart.html',
  styleUrls: ['./cart.css'],
})
export class CartPage implements OnInit {
  items: CartItem[] = [];
  errorMsg = '';
  username = localStorage.getItem('username') || localStorage.getItem('userId') || '';

  constructor(private cart: CartService, private router: Router) {}

  ngOnInit(): void {
    this.refresh();
  }

  refresh() {
    this.items = this.cart.getItems();
    this.errorMsg = '';
  }

  inc(i: CartItem) {
    if (i.qty >= i.availableQty) return;
    this.cart.increment(i.productId);
    this.refresh();
  }
  dec(i: CartItem) {
    this.cart.decrement(i.productId);
    this.refresh();
  }
  remove(i: CartItem) {
    this.cart.remove(i.productId);
    this.refresh();
  }

  get subtotal(): number {
    return this.cart.subtotal();
  }

  proceedToBuy() {
    const invalid = this.items.find((i) => i.qty > i.availableQty);
    if (invalid) {
      this.errorMsg = `Not enough quantity for "${invalid.name}". Available: ${invalid.availableQty}`;
      return;
    }

    this.cart.clear();
    alert('Order placed successfully!');
    this.router.navigate(['/catalog']);
  }

  backToCatalog() {
    this.router.navigate(['/catalog']);
  }
}
