import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Productservice } from '../productservice';
import { Product } from '../product';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-productlist',
  imports: [RouterLink, CommonModule],
  templateUrl: './productlist.html',
  styleUrl: './productlist.css'
})
export class Productlist implements OnInit {
  products: Product[] = [];
  isLoading = true;
  errorMessage = '';

  constructor(
    private productService: Productservice,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit() {
    console.log("==> Productlist Component Initialized");
    this.loadProducts();
  }

  loadProducts() {
    this.isLoading = true;
    this.errorMessage = '';

    console.log('Attempting to fetch products from: http://localhost:8080/products');

    this.productService.getProducts().subscribe({
      next: (data: Product[]) => {
        this.products = data;
        this.isLoading = false;
        console.log('Products fetched successfully:', data);
        this.cdr.detectChanges();
      },
      error: (error) => {
        this.isLoading = false;
        this.errorMessage = 'Failed to load products. Please check if JSON server is running.';
        console.error('Error fetching products:', error);
        this.cdr.detectChanges();
      }
    });
  }

  addProduct() {
    this.router.navigate(['/productadd']);
  }

  deleteProduct(id: number) {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(id).subscribe({
        next: () => {
          console.log('Product deleted successfully');
          this.loadProducts();
          this.cdr.detectChanges();
        },
        error: (error) => {
          console.error('Error deleting product:', error);
          alert('Failed to delete product. Please try again.');
          this.cdr.detectChanges();
        }
      });
    }
  }
  goToPurchase() {
    this.router.navigate(['/productpurchase']);
  }

  goToOrderHistory() {
    this.router.navigate(['/orderhistory']);
  }

}