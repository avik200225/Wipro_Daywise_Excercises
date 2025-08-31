import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProductService, PageResponse } from '../../services/product-service';
import { Product } from '../../interface/product';

type SearchField = 'description' | 'category' | 'price' | 'name' | 'make';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [CommonModule, CurrencyPipe, FormsModule],
  templateUrl: './admin-dashboard.html',
  styleUrls: ['./admin-dashboard.css']
})
export class AdminDashboard implements OnInit {
  // listing data
  products: Product[] = [];
  page: PageResponse<Product> | null = null;

  // selection/editing
  selectedProduct: Product | null = null;
  newProduct: Product = {
    productName: '',
    productDesc: '',
    productCat: '',
    make: '',
    productAvailableQty: 0,
    productPrice: 0,
    productImgUrl: '',
    dateOfManufacture: ''
  };

  // ui state
  errorMessage = '';
  showAddForm = false;
  username = localStorage.getItem('userId') || localStorage.getItem('username') || '';

  // search + pagination state
  searchCategory: SearchField = 'description';
  searchTerm = '';
  pageSize = 6;
  currentPage = 1;        // UI 1-based
  totalPages = 1;

  constructor(
    private svc: ProductService,
    private cdr: ChangeDetectorRef,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.loadPage(1);
  }

  // ---------- listing & paging ----------
  loadPage(uiPage: number) {
    const pageIdx = Math.max(0, uiPage - 1);
    const fieldMap: Record<SearchField, any> = {
      description: 'description',
      category: 'category',
      price: 'price',
      name: 'name',
      make: 'make'
    };
    this.svc.search(fieldMap[this.searchCategory], this.searchTerm.trim(), pageIdx, this.pageSize)
      .subscribe({
        next: (pg) => {
          this.page = pg;
          this.products = pg.content;
          this.currentPage = pg.number + 1;
          this.totalPages = pg.totalPages || 1;
          this.errorMessage = '';
          this.cdr.detectChanges();
        },
        error: (err) => {
          this.errorMessage = 'Unable to load products. ' + (err?.message ?? '');
          this.products = [];
          this.page = null;
          this.cdr.detectChanges();
        }
      });
  }

  onSearch() {
    this.loadPage(1);
  }

  // ---------- add ----------
  toggleAdd() {
    this.showAddForm = !this.showAddForm;
    if (this.showAddForm) {
      this.selectedProduct = null;
      this.newProduct = {
        productName: '',
        productDesc: '',
        productCat: '',
        make: '',
        productAvailableQty: 0,
        productPrice: 0,
        productImgUrl: '',
        dateOfManufacture: ''
      };
    }
  }

  saveNew() {
    // minimal validation
    if (!this.newProduct.productName?.trim()) {
      alert('Product name is mandatory');
      return;
    }
    if (isNaN(Number(this.newProduct.productAvailableQty))) {
      alert('QTY must be a number');
      return;
    }
    if (isNaN(Number(this.newProduct.productPrice))) {
      alert('Price must be a number');
      return;
    }
    this.svc.createProduct(this.newProduct).subscribe({
      next: () => {
        this.toggleAdd();
        this.loadPage(this.currentPage);
      },
      error: (err) => alert('Create failed: ' + (err?.message ?? ''))
    });
  }

  // ---------- edit ----------
  startEdit(p: Product) {
    this.selectedProduct = { ...p };
    this.showAddForm = false;
  }

  cancelEdit() { this.selectedProduct = null; }

  saveEdit() {
    if (!this.selectedProduct?.productId) return;
    this.svc.updateProduct(this.selectedProduct.productId, this.selectedProduct).subscribe({
      next: () => {
        this.selectedProduct = null;
        this.loadPage(this.currentPage);
      },
      error: (err) => alert('Update failed: ' + (err?.message ?? ''))
    });
  }

  // ---------- delete ----------
  remove(p: Product) {
    if (!p.productId) return;
    if (!confirm('Delete this product?')) return;
    this.svc.deleteProduct(p.productId).subscribe({
      next: () => this.loadPage(this.currentPage),
      error: (err) => alert('Delete failed: ' + (err?.message ?? ''))
    });
  }

  // ---------- logout ----------
  logout() {
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('jwt');
    localStorage.removeItem('userId');
    localStorage.removeItem('username');
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }
}
