package com.example.lilyclothing.Service.ServiceImpl;

import com.example.lilyclothing.Entity.CartItems;
import com.example.lilyclothing.Pojo.CartItemsPojo;
import com.example.lilyclothing.Repository.CartItemsRepository;
import com.example.lilyclothing.Service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemsRepository cartItemRepository;

    @Override
    public void saveData(CartItemsPojo cartItemPojo) {
        CartItems cartItem = new CartItems();
        cartItem.setQuantity(cartItemPojo.getQuantity());
        cartItemRepository.save(cartItem);
    }

    @Override
    public CartItems getCartItemById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<CartItems> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItems updateCartItem(Long id, CartItemsPojo cartItemPojo) {
        CartItems cartItem = cartItemRepository.findById(id).orElseThrow();
        cartItem.setQuantity(cartItemPojo.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}

