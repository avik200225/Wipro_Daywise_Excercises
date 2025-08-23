import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Productservice } from '../productservice';

@Component({
  selector: 'app-productdelete',
  templateUrl: './productdelete.html',
  styleUrl: './productdelete.css'
})
export class Productdelete implements OnInit {
  id: number | null = null;

  constructor(
    private route: ActivatedRoute,
    private productService: Productservice,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.id = +id;
      console.log("Product to be deleted has id:", this.id);
      this.productService.deleteProduct(this.id).subscribe({
        next: () => {
          console.log('Product deleted successfully');
          this.cdr.detectChanges(); 
          this.router.navigate(['/productlist']);
        },
        error: (error) => {
          console.error('Error deleting product:', error);
          this.cdr.detectChanges(); 
        }
      });
    }
  }
}