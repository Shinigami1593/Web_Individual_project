package com.example.lilyclothing.Service.ServiceImpl;

import com.example.lilyclothing.Entity.OrderItem;
import com.example.lilyclothing.Pojo.OrderItemPojo;
import com.example.lilyclothing.Repository.OrderItemsRepository;
import com.example.lilyclothing.Service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemsRepository orderItemRepository;

    @Override
    public void saveData(OrderItemPojo orderItemPojo) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemPojo.getQuantity());
        orderItem.setPrice(orderItemPojo.getPrice());
        orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItemPojo orderItemPojo) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow();
        orderItem.setQuantity(orderItemPojo.getQuantity());
        orderItem.setPrice(orderItemPojo.getPrice());
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}

