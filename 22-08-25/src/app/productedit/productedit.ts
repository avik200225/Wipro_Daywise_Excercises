import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Productservice } from '../productservice';
import { Product } from '../product';
import { RouterModule } from '@angular/router'; 

@Component({
  selector: 'app-productedit',
  imports: [FormsModule, RouterModule],
  templateUrl: './productedit.html',
  styleUrl: './productedit.css'
})
export class Productedit implements OnInit {
  product: Product = {
    id: 0,
    name: '',
    category: '',
    price: 0,
    quantity: 0
  };

  constructor(
    private route: ActivatedRoute,
    private productService: Productservice,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.productService.findProduct(+id).subscribe({
        next: (product) => {
          this.product = product;
          this.cdr.detectChanges();
        },
        error: (error) => {
          console.error('Error fetching product:', error);
          this.cdr.detectChanges();
        }
      });
    }
  }

  save() {
    if (!this.product.name || !this.product.category || this.product.price <= 0 || this.product.quantity < 0) {
      alert('Please fill all fields with valid values');
      return;
    }

    this.productService.updateProduct(this.product).subscribe({
      next: () => {
        console.log('Product updated successfully');
        this.cdr.detectChanges();
        this.router.navigate(['/productlist']);
      },
      error: (error) => {
        console.error('Error updating product:', error);
        this.cdr.detectChanges();
      }
    });
  }
}