package com.example.lilyclothing.Service;



import com.example.lilyclothing.Entity.Cart;
import com.example.lilyclothing.Pojo.CartPojo;

import java.util.List;

public interface CartService {
    void saveData(CartPojo cartPojo);
    Cart getCartById(Long cartId);
    List<Cart> getAllCarts();
    Cart updateCart(Long id, CartPojo cartPojo);
    void deleteCart(Long id);
}


