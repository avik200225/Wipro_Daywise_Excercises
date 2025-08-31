//package com.wipro.orderms.service.impl;
//
//import com.wipro.orderms.client.ProductClient;
//import com.wipro.orderms.dto.AddOrUpdateReq;
//import com.wipro.orderms.dto.CartResponse;
//import com.wipro.orderms.dto.ProductDTO;
//import com.wipro.orderms.entity.Cart;
//import com.wipro.orderms.repo.CartRepo;
//import com.wipro.orderms.service.CartService;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class CartServiceImpl implements CartService {
//
//  private final CartRepo repo;
//  private final ProductClient productClient;
//
//  @Override
//  public CartResponse addProduct(AddOrUpdateReq req) {
//    Cart cart = repo.findByUserId(req.getUserId()).orElseGet(() -> {
//      Cart c = new Cart();
//      c.setUserId(req.getUserId());
//      c.setProdDetails(new HashMap<>());
//      return repo.save(c);
//    });
//    // Map<Long,Integer>
//    cart.getProdDetails().merge(req.getProductId(), req.getQty(), Integer::sum);
//    recalcTotals(cart);
//    repo.save(cart);
//    return toResponse(cart, true);
//  }
//
//  @Override
//  public CartResponse updateQuantity(AddOrUpdateReq req) {
//    Cart cart = repo.findByUserId(req.getUserId())
//        .orElseThrow(() -> new NoSuchElementException("Cart not found"));
//    if (req.getQty() == null || req.getQty() <= 0) {
//      cart.getProdDetails().remove(req.getProductId());
//    } else {
//      cart.getProdDetails().put(req.getProductId(), req.getQty());
//    }
//    recalcTotals(cart);
//    repo.save(cart);
//    return toResponse(cart, true);
//  }
//
//  @Override
//  public void deleteProduct(Integer userId, Long productId) { // Long!
//    Cart cart = repo.findByUserId(userId)
//        .orElseThrow(() -> new NoSuchElementException("Cart not found"));
//    cart.getProdDetails().remove(productId);
//    recalcTotals(cart);
//    repo.save(cart);
//  }
//
//  @Override
//  public CartResponse getCart(Integer userId) {
//    Cart cart = repo.findByUserId(userId)
//        .orElseGet(() -> repo.save(Cart.builder()
//            .userId(userId).prodDetails(new HashMap<>()).build()));
//    recalcTotals(cart);
//    return toResponse(cart, true);
//  }
//
//  private void recalcTotals(Cart cart) {
//    int totalQty = cart.getProdDetails().values().stream()
//        .mapToInt(Integer::intValue).sum();
//
//    BigDecimal total = BigDecimal.ZERO;
//    for (var e : cart.getProdDetails().entrySet()) { // Map.Entry<Long,Integer>
//      ProductDTO p = safeGetProduct(e.getKey());
//      BigDecimal price = (p != null && p.getProductPrice() != null)
//          ? p.getProductPrice() : BigDecimal.ZERO;
//      total = total.add(price.multiply(BigDecimal.valueOf(e.getValue())));
//    }
//    cart.setTotalQty(totalQty);
//    cart.setTotalPrice(total.doubleValue()); // keep Double field
//  }
//
//  private ProductDTO safeGetProduct(Long productId) { // Long!
//    try { return productClient.getProduct(productId); }
//    catch (Exception ex) { return null; }
//  }
//
//  private CartResponse toResponse(Cart cart, boolean enrich) {
//    List<CartResponse.Item> items = new ArrayList<>();
//    for (Map.Entry<Long,Integer> e : cart.getProdDetails().entrySet()) {
//      ProductDTO p = enrich ? safeGetProduct(e.getKey()) : null;
//      items.add(CartResponse.Item.builder()
//          .productId(e.getKey())
//          .qty(e.getValue())
//          .name(p != null ? p.getProductName() : null)
//          .price(p != null ? p.getProductPrice() : null)       // BigDecimal
//          .availableQty(p != null ? p.getProductAvailableQty() : null)
//          .imgUrl(p != null ? p.getProductImgUrl() : null)
//          .build());
//    }
//    return CartResponse.builder()
//        .id(cart.getId())
//        .userId(cart.getUserId())
//        .items(items)
//        .totalQty(cart.getTotalQty())
//        .totalPrice(cart.getTotalPrice())
//        .build();
//  }
//}

