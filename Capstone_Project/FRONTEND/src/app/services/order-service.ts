import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class OrderService {
  private baseUrl = 'http://localhost:8080/order';

  constructor(private http: HttpClient) {}

  /** Place a new order */
  createOrder(payload: { userId: number | string }): Observable<any> {
    return this.http.post(`${this.baseUrl}`, payload);
  }

  /** Cancel an order */
  cancelOrder(orderId: number, userId: number | string): Observable<any> {
    return this.http.put(`${this.baseUrl}/${orderId}?userId=${userId}`, {});
  }

  /** List orders for a user */
  getOrdersByUser(userId: number | string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/${userId}`);
  }

  /** Admin: list all orders */
  getAllOrders(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`);
  }

  /** Details of an order */
  getOrderDetails(orderId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/details/${orderId}`);
  }
}
