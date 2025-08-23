
import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Productservice } from '../productservice';
import { Router } from '@angular/router';
import { Product } from '../product';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router'; 

@Component({
  selector: 'app-productpurchase',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterModule],
  templateUrl: './productpurchase.html',
  styleUrls: ['./productpurchase.css']
})
export class Productpurchase implements OnInit {
  products: Product[] = [];
  selectedProductId: number | null = null;
  quantity: number = 1;
  isLoading = true;
  errorMessage = '';
  maxQuantity: number = 0;

  constructor(
    private productService: Productservice,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    this.isLoading = true;
    this.errorMessage = '';
    this.productService.getProducts().subscribe({
      next: (data: Product[]) => {
        this.products = data;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (error) => {
        this.isLoading = false;
        this.errorMessage = 'Failed to load products. Please try again.';
        console.error('Error fetching products:', error);
        this.cdr.detectChanges();
      }
    });
  }

  onProductChange() {
    const selectedProduct = this.products.find(p => p.id === this.selectedProductId);
    this.maxQuantity = selectedProduct ? selectedProduct.quantity : 0;
    console.log('Selected Product:', selectedProduct, 'Max Quantity:', this.maxQuantity);
    if (this.quantity > this.maxQuantity) {
      this.quantity = this.maxQuantity;
      console.log('Quantity adjusted to:', this.quantity);
    }
    this.cdr.detectChanges();
  }

  placeOrder() {
    console.log('Placing order - Selected ID:', this.selectedProductId, 'Quantity:', this.quantity, 'Max Quantity:', this.maxQuantity);
    if (!this.selectedProductId || this.quantity <= 0 || this.quantity < this.maxQuantity) {
      alert('Please select a product and enter a valid quantity (Max: ' + this.maxQuantity + ')');
      return;
    }

    this.productService.purchaseProduct(this.selectedProductId, this.quantity).subscribe({
      next: () => {
        console.log('Order placed successfully');
        this.cdr.detectChanges();
        this.router.navigate(['/orderhistory']);
      },
      error: (error) => {
        console.error('Error placing order:', error);
        alert('Failed to place order. ' + (error.message.includes('Insufficient') ? 'Insufficient quantity available.' : 'Please try again.'));
        this.cdr.detectChanges();
      }
    });
  }
}