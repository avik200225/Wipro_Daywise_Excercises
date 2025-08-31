//package com.wipro.orderms.controller;
//
//import com.wipro.orderms.dto.*;
//import com.wipro.orderms.service.CartService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/cart")
//@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
//public class CartController {
//
//  private final CartService service;
//
//  // 1) Add Product -> POST /cart/addProd
//  @PostMapping("/addProd")
//  public CartResponse add(@RequestBody AddOrUpdateReq req) {
//    return service.addProduct(req);
//  }
//
//  // 3) Change Qty -> PUT /cart/update
//  @PutMapping("/update")
//  public CartResponse update(@RequestBody AddOrUpdateReq req) {
//    return service.updateQuantity(req);
//  }
//
//  // 2) Delete product -> DELETE /cart/deleteProd/{userId}/{productId}
////src/main/java/com/wipro/orderms/controller/CartController.java
//@DeleteMapping("/deleteProd/{userId}/{productId}")
//public String delete(@PathVariable Integer userId, @PathVariable Long productId) {
// service.deleteProduct(userId, productId);
// return "OK";
//}
//
//
//  // 4) View cart -> GET /cart/{userId}
//  @GetMapping("/{userId}")
//  public CartResponse get(@PathVariable Integer userId) {
//    return service.getCart(userId);
//  }
//}

