package com.example.lilyclothing.Repository;

import com.example.lilyclothing.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
