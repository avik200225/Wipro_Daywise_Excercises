package com.wipro.orderms.service.impl;

import com.wipro.orderms.client.ProductClient;
import com.wipro.orderms.dto.CartAddRequest;
import com.wipro.orderms.dto.CartUpdateRequest;
import com.wipro.orderms.dto.ProductDTO;
import com.wipro.orderms.entity.Cart;
import com.wipro.orderms.repo.CartRepo;
import com.wipro.orderms.service.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

  private final CartRepo repo;
  private final ProductClient productClient;

  @Override
  public Cart view(Integer userId) {
    return repo.findByUserId(userId).orElseGet(() -> {
      Cart c = Cart.builder().userId(userId).build();
      return repo.save(c);
    });
  }

  @Override @Transactional
  public Cart add(CartAddRequest req) {
    Cart cart = view(req.getUserId());
    cart.getProdDetails().merge(req.getProductId(), req.getQty(), Integer::sum);
    recompute(cart);
    return repo.save(cart);
  }

  @Override @Transactional
  public Cart update(CartUpdateRequest req) {
    Cart cart = view(req.getUserId());
    if (req.getQty() <= 0) cart.getProdDetails().remove(req.getProductId());
    else cart.getProdDetails().put(req.getProductId(), req.getQty());
    recompute(cart);
    return repo.save(cart);
  }

  @Override @Transactional
  public Cart delete(Integer userId, Integer productId) {
    Cart cart = view(userId);
    cart.getProdDetails().remove(productId);
    recompute(cart);
    return repo.save(cart);
  }

  private void recompute(Cart cart) {
    int tq = 0; double tp = 0.0;
    for (Map.Entry<Integer,Integer> e : cart.getProdDetails().entrySet()) {
      ProductDTO p = productClient.getById(e.getKey());
      double price = p.getProductPrice()==null?0.0:p.getProductPrice();
      tq += e.getValue();
      tp += price * e.getValue();
    }
    cart.setTotalQty(tq);
    cart.setTotalPrice(tp);
  }
}
