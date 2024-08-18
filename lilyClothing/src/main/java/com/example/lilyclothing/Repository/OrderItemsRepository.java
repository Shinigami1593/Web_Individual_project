package com.example.lilyclothing.Repository;

import com.example.lilyclothing.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Long> {
}
