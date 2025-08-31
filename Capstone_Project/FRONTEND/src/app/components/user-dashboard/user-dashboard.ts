import { ChangeDetectorRef, Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../services/product-service';
import { CartService } from '../../services/cart-service';
import { Product } from '../../interface/product';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-dashboard',
  standalone: true,
  imports: [CurrencyPipe, CommonModule, FormsModule],
  templateUrl: './user-dashboard.html',
  styleUrls: ['./user-dashboard.css']
})
export class UserDashboard implements OnInit {
  products: Product[] = [];
  errorMessage = '';
  searchTerm = '';
  cartCount = 0;

 
  private allProducts: Product[] = [];
  private chunk = 8;
  private loaded = 0;

  constructor(
    private svc: ProductService,
    private cart: CartService,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cartCount = this.cart.getCount();  
    this.load();
  }

  load() {
    this.svc.getAllProducts().subscribe({
      next: (list) => {
        this.allProducts = list || [];
        this.appendMore();
      },
      error: (err) => {
        this.errorMessage = 'Error loading products: ' + (err?.message ?? '');
        this.cdr.detectChanges();
      }
    });
  }

  appendMore() {
    const next = this.allProducts.slice(this.loaded, this.loaded + this.chunk);
    this.products = this.products.concat(next);
    this.loaded += next.length;
    this.cdr.detectChanges();
  }

  @HostListener('window:scroll', [])
  onScroll() {
    if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight - 2) {
      if (this.loaded < this.allProducts.length) this.appendMore();
    }
  }

  get filtered(): Product[] {
    if (!this.searchTerm) return this.products;
    const s = this.searchTerm.toLowerCase();
    return this.products.filter(p =>
      (p.productName || '').toLowerCase().includes(s) ||
      (p.productDesc || '').toLowerCase().includes(s) ||
      (p.productCat || '').toLowerCase().includes(s)
    );
  }


  addToCart(p: Product) {
    this.cart.add(p, 1);              
    this.cartCount = this.cart.getCount(); 
  }

  goToCart() {
    this.router.navigate(['/cart']);
  }
}

