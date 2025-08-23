import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class Productservice {
  private apiUrl = 'http://localhost:9000/api/products';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl)
      .pipe(
        tap(data => console.log('Products fetched:', data)),
        catchError(error => {
          console.error('Error fetching products:', error);
          return throwError(() => new Error('Failed to fetch products'));
        })
      );
  }

  addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.apiUrl, product)
      .pipe(
        tap(data => console.log('Product added:', data)),
        catchError(error => {
          console.error('Error adding product:', error);
          return throwError(() => new Error('Failed to add product'));
        })
      );
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`)
      .pipe(
        tap(() => console.log('Product deleted:', id)),
        catchError(error => {
          console.error('Error deleting product:', error);
          return throwError(() => new Error('Failed to delete product'));
        })
      );
  }

  findProduct(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/${id}`)
      .pipe(
        tap(data => console.log('Product found:', data)),
        catchError(error => {
          console.error('Error finding product:', error);
          return throwError(() => new Error('Failed to find product'));
        })
      );
  }

  updateProduct(product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.apiUrl}/${product.id}`, product)
      .pipe(
        tap(data => console.log('Product updated:', data)),
        catchError(error => {
          console.error('Error updating product:', error);
          return throwError(() => new Error('Failed to update product'));
        })
      );
  }

  purchaseProduct(id: number, quantity: number): Observable<Product> {
    return this.http.post<Product>(`${this.apiUrl}/${id}/purchase`, { quantity })
      .pipe(
        tap(data => console.log('Product purchased:', data)),
        catchError(error => {
          console.error('Error purchasing product:', error);
          return throwError(() => new Error('Failed to purchase product'));
        })
      );
  }

  getOrderHistory(): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.apiUrl}/order-history`)
      .pipe(
        tap(data => console.log('Order history fetched:', data)),
        catchError(error => {
          console.error('Error fetching order history:', error);
          return throwError(() => new Error('Failed to fetch order history'));
        })
      );
  }
}
export interface Order {
  id?: number;
  productId: number;
  productName: string;
  quantity: number;
  orderDate: string;
}