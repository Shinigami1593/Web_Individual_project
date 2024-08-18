package com.example.lilyclothing.Pojo;


import io.cucumber.java.bs.A;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPojo {
    private Long orderId;
    private Date orderDate;
    private Double total;
    private String status;
}
