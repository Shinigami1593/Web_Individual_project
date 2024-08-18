package com.example.lilyclothing.Service.ServiceImpl;

import com.example.lilyclothing.Entity.Order;
import com.example.lilyclothing.Pojo.OrderPojo;
import com.example.lilyclothing.Repository.OrderRepository;
import com.example.lilyclothing.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void saveData(OrderPojo orderPojo) {
        Order order = new Order();
        order.setOrderDate(orderPojo.getOrderDate());
        order.setTotal(orderPojo.getTotal());
        order.setStatus(orderPojo.getStatus());
        orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, OrderPojo orderPojo) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setOrderDate(orderPojo.getOrderDate());
        order.setTotal(orderPojo.getTotal());
        order.setStatus(orderPojo.getStatus());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
