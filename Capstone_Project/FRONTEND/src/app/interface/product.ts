export interface Product {
  productId?: number;            
  productName: string;
  productDesc: string;
  productCat: string;
  make: string;
  productAvailableQty: number;
  productPrice: number;
  productImgUrl: string;
  dateOfManufacture?: string;   
}
