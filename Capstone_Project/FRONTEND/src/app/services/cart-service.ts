import { Injectable } from '@angular/core';
import { Product } from '../interface/product';

export interface CartItem {
  productId: number;
  name: string;
  price: number;
  availableQty: number;
  img?: string | null;
  qty: number;
}

const CART_KEY = 'cartItems';
const CART_COUNT_KEY = 'cartCount';

@Injectable({ providedIn: 'root' })
export class CartService {

  private read(): CartItem[] {
    try { return JSON.parse(localStorage.getItem(CART_KEY) || '[]'); }
    catch { return []; }
  }
  private write(items: CartItem[]) {
    localStorage.setItem(CART_KEY, JSON.stringify(items));
    const count = items.reduce((s, i) => s + i.qty, 0);
    localStorage.setItem(CART_COUNT_KEY, String(count));
  }

  getItems(): CartItem[] { return this.read(); }
  getCount(): number { return Number(localStorage.getItem(CART_COUNT_KEY) || '0'); }
  clear() { this.write([]); }

  add(product: Product, qty = 1) {
    const items = this.read();
    const id = Number(product.productId);
    const idx = items.findIndex(i => i.productId === id);
    if (idx >= 0) {
      items[idx].qty = Math.min(items[idx].qty + qty, items[idx].availableQty);
    } else {
      items.push({
        productId: id,
        name: product.productName,
        price: Number(product.productPrice || 0),
        availableQty: Number(product.productAvailableQty || 0),
        img: product.productImgUrl ?? null,
        qty: Math.min(qty, Number(product.productAvailableQty || 0))
      });
    }
    this.write(items);
  }

  increment(id: number) {
    const items = this.read();
    const it = items.find(i => i.productId === id);
    if (it) { it.qty = Math.min(it.qty + 1, it.availableQty); this.write(items); }
  }

  decrement(id: number) {
    const items = this.read();
    const it = items.find(i => i.productId === id);
    if (!it) return;
    it.qty = Math.max(0, it.qty - 1);
    if (it.qty === 0) this.remove(id);
    else this.write(items);
  }

  remove(id: number) {
    const items = this.read().filter(i => i.productId !== id);
    this.write(items);
  }

  subtotal(): number {
    return this.read().reduce((s, i) => s + i.qty * i.price, 0);
  }
}
