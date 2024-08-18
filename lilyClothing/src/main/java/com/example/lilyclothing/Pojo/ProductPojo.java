package com.example.lilyclothing.Pojo;

import com.example.lilyclothing.Entity.CartItems;
import com.example.lilyclothing.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPojo {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
}
