import { Routes } from '@angular/router';
import { Productlist } from './productlist/productlist';
import { Productadd } from './productadd/productadd';
import { Productedit } from './productedit/productedit';
import { Productdelete } from './productdelete/productdelete';
import { Productpurchase } from './productpurchase/productpurchase';
import { Orderhistory } from './orderhistory/orderhistory';

export const routes: Routes = [
  { path: '', component: Productlist },
  { path: 'productlist', component: Productlist },
  { path: 'productadd', component: Productadd },
  { path: 'productedit/:id', component: Productedit },
  { path: 'productdelete/:id', component: Productdelete },
  { path: 'productpurchase', component: Productpurchase },
  { path: 'orderhistory', component: Orderhistory }
];