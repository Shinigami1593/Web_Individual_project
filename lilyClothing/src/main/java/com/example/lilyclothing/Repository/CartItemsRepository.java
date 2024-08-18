package com.example.lilyclothing.Repository;

import com.example.lilyclothing.Entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
}
