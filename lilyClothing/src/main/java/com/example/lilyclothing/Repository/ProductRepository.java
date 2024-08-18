package com.example.lilyclothing.Repository;

import com.example.lilyclothing.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
