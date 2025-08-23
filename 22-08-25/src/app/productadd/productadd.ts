import { Component, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Productservice } from '../productservice';
import { Router } from '@angular/router';
import { Product } from '../product';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-productadd',
  imports: [FormsModule, RouterModule],
  templateUrl: './productadd.html',
  styleUrl: './productadd.css'
})
export class Productadd {
  product: Product = {
    name: '',
    category: '',
    price: 0,
    quantity: 0
  };

  constructor(
    private productService: Productservice, 
    private router: Router,
    private cdr: ChangeDetectorRef
  ) { }

  submit() {
    if (!this.product.name || !this.product.category || this.product.price <= 0 || this.product.quantity < 0) {
      alert('Please fill all fields with valid values');
      return;
    }

    this.productService.addProduct(this.product).subscribe({
      next: () => {
        console.log('Product added successfully');
        this.cdr.detectChanges();
        this.router.navigate(['/productlist']);
      },
      error: (error) => {
        console.error('Error adding product:', error);
        this.cdr.detectChanges();
      }
    });
  }
}