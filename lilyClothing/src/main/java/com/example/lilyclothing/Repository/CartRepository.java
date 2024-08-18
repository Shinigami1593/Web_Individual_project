package com.example.lilyclothing.Repository;

import com.example.lilyclothing.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
