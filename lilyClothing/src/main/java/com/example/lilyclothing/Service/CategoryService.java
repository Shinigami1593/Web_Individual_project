package com.example.lilyclothing.Service;

import com.example.lilyclothing.Entity.Category;
import com.example.lilyclothing.Pojo.CategoryPojo;

import java.util.List;

public interface CategoryService {
    void saveData(CategoryPojo categoryPojo);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();
    Category updateCategory(Long id, CategoryPojo categoryPojo);
    void deleteCategory(Long id);
}

