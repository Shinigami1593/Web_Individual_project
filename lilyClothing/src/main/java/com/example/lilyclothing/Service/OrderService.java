package com.example.lilyclothing.Service;


import com.example.lilyclothing.Entity.Order;
import com.example.lilyclothing.Pojo.OrderPojo;

import java.util.List;

public interface OrderService {
    void saveData(OrderPojo orderPojo);
    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    Order updateOrder(Long id, OrderPojo orderPojo);
    void deleteOrder(Long id);
}

