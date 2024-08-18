package com.example.lilyclothing.Service.ServiceImpl;

import com.example.lilyclothing.Entity.Category;
import com.example.lilyclothing.Pojo.CategoryPojo;
import com.example.lilyclothing.Repository.CategoryRepository;
import com.example.lilyclothing.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void saveData(CategoryPojo categoryPojo) {
        Category category = new Category();
        category.setName(categoryPojo.getName());
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, CategoryPojo categoryPojo) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryPojo.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

