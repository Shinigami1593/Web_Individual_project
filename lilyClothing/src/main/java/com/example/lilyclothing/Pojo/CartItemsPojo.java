package com.example.lilyclothing.Pojo;

import com.example.lilyclothing.Entity.Cart;
import com.example.lilyclothing.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemsPojo {
    private Long cartItemId;
    private Integer quantity;
    private Cart cart;
    private Product product;

}
