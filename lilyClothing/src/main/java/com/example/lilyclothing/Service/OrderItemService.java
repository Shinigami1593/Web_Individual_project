package com.example.lilyclothing.Service;



import com.example.lilyclothing.Entity.OrderItem;
import com.example.lilyclothing.Pojo.OrderItemPojo;

import java.util.List;

public interface OrderItemService {
    void saveData(OrderItemPojo orderItemPojo);
    OrderItem getOrderItemById(Long id);
    List<OrderItem> getAllOrderItems();
    OrderItem updateOrderItem(Long id, OrderItemPojo orderItemPojo);
    void deleteOrderItem(Long id);
}
