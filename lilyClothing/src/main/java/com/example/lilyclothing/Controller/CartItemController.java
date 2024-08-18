package com.example.lilyclothing.Controller;

import com.example.lilyclothing.Entity.CartItems;
import com.example.lilyclothing.Pojo.CartItemsPojo;
import com.example.lilyclothing.Service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItems")
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;

    @PostMapping("/save")
    public void save(@RequestBody CartItemsPojo cartItemPojo) {
        cartItemService.saveData(cartItemPojo);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CartItems> getCartItemById(@PathVariable Long id) {
        CartItems cartItem = cartItemService.getCartItemById(id);
        if (cartItem != null) {
            return ResponseEntity.ok(cartItem);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public List<CartItems> getAll() {
        return cartItemService.getAllCartItems();
    }

    @PutMapping("/update/{id}")
    public CartItems updateCartItem(@PathVariable Long id, @RequestBody CartItemsPojo cartItemPojo) {
        return cartItemService.updateCartItem(id, cartItemPojo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}

