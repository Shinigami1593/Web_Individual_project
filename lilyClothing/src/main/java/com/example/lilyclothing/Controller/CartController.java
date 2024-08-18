package com.example.lilyclothing.Controller;

import com.example.lilyclothing.Entity.Cart;
import com.example.lilyclothing.Pojo.CartPojo;
import com.example.lilyclothing.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/save")
    public void save(@RequestBody CartPojo cartPojo) {
        cartService.saveData(cartPojo);
    }

    @GetMapping("/getById/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public List<Cart> getAll() {
        return cartService.getAllCarts();
    }

    @PutMapping("/update/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody CartPojo cartPojo) {
        return cartService.updateCart(id, cartPojo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}


