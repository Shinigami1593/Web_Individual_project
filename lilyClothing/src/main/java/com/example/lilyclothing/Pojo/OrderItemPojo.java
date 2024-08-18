package com.example.lilyclothing.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPojo {
    private Long id;
    private Integer quantity;
    private Double price;
}
