package com.example.lilyclothing.Controller;

import com.example.lilyclothing.Entity.Order;
import com.example.lilyclothing.Pojo.OrderPojo;
import com.example.lilyclothing.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/save")
    public void save(@RequestBody OrderPojo orderPojo) {
        orderService.saveData(orderPojo);
    }

    @GetMapping("/getById/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody OrderPojo orderPojo) {
        return orderService.updateOrder(id, orderPojo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
