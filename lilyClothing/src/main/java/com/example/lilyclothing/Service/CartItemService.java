package com.example.lilyclothing.Service;


import com.example.lilyclothing.Entity.CartItems;
import com.example.lilyclothing.Pojo.CartItemsPojo;

import java.util.List;

public interface CartItemService {
    void saveData(CartItemsPojo cartItemPojo);
    CartItems getCartItemById(Long id);
    List<CartItems> getAllCartItems();
    CartItems updateCartItem(Long id, CartItemsPojo cartItemPojo);
    void deleteCartItem(Long id);
}

