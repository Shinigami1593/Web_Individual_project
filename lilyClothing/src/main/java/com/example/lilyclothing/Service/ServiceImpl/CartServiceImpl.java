package com.example.lilyclothing.Service.ServiceImpl;

import com.example.lilyclothing.Entity.Cart;
import com.example.lilyclothing.Pojo.CartPojo;
import com.example.lilyclothing.Repository.CartRepository;
import com.example.lilyclothing.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public void saveData(CartPojo cartPojo) {
        Cart cart = new Cart();
        cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart updateCart(Long id, CartPojo cartPojo) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}

