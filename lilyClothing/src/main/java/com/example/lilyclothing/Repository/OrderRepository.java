package com.example.lilyclothing.Repository;

import com.example.lilyclothing.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
