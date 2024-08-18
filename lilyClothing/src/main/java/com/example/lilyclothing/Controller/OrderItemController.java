package com.example.lilyclothing.Controller;


import com.example.lilyclothing.Entity.OrderItem;
import com.example.lilyclothing.Pojo.OrderItemPojo;
import com.example.lilyclothing.Service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItems")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    @PostMapping("/save")
    public void save(@RequestBody OrderItemPojo orderItemPojo) {
        orderItemService.saveData(orderItemPojo);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        if (orderItem != null) {
            return ResponseEntity.ok(orderItem);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public List<OrderItem> getAll() {
        return orderItemService.getAllOrderItems();
    }

    @PutMapping("/update/{id}")
    public OrderItem updateOrderItem(@PathVariable Long id, @RequestBody OrderItemPojo orderItemPojo) {
        return orderItemService.updateOrderItem(id, orderItemPojo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}


