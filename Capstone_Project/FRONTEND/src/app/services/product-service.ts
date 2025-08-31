import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Product } from '../interface/product';

export interface PageResponse<T> {
  content: T[];
  number: number;
  size: number;
  totalElements: number;
  totalPages: number;
}

@Injectable({ providedIn: 'root' })
export class ProductService {
  // Gateway
  private gwUrl = 'http://localhost:8080/product';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const raw =
      (localStorage.getItem('jwtToken') ||
        localStorage.getItem('jwt') ||
        localStorage.getItem('token') ||
        ''
      ).trim();

    const headers: Record<string, string> = { 'Content-Type': 'application/json' };
    if (raw) {
      headers['Authorization'] = raw.startsWith('Bearer ') ? raw : `Bearer ${raw}`;
    }
    return new HttpHeaders(headers);
  }

  // helpers
  private getList(url: string): Observable<Product[]> {
    return this.http.get<Product[]>(url, { headers: this.getAuthHeaders() });
  }

  private getPaged<T>(url: string, params: HttpParams): Observable<PageResponse<T>> {
    return this.http.get<PageResponse<T>>(url, { headers: this.getAuthHeaders(), params });
  }

  private toPage<T>(items: T[], page: number, size: number): PageResponse<T> {
    const start = page * size;
    const content = items.slice(start, start + size);
    const totalElements = items.length;
    const totalPages = Math.max(1, Math.ceil(totalElements / size));
    return { content, number: page, size, totalElements, totalPages };
  }

  //list
  getAllProducts(): Observable<Product[]> {
    return this.getList(this.gwUrl);
  }

  // CRUD 
  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.gwUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.gwUrl, product, { headers: this.getAuthHeaders() });
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.gwUrl}/${id}`, product, { headers: this.getAuthHeaders() });
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${this.gwUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  //Search + Pagination
  search(
    field: 'name' | 'category' | 'description' | 'make' | 'price',
    q: string,
    page = 0,
    size = 10
  ): Observable<PageResponse<Product>> {
    if (!q || !q.trim()) {
      return this.getAllProducts().pipe(map(list => this.toPage(list, page, size)));
    }

    const params = new HttpParams()
      .set('field', field)
      .set('q', q)
      .set('page', String(page))
      .set('size', String(size));

    return this.getPaged<Product>(`${this.gwUrl}/search`, params);
  }
}


