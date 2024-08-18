package com.example.lilyclothing.Controller;

import com.example.lilyclothing.Entity.Category;
import com.example.lilyclothing.Pojo.CategoryPojo;
import com.example.lilyclothing.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/save")
    public void save(@RequestBody CategoryPojo categoryPojo) {
        categoryService.saveData(categoryPojo);
    }

    @GetMapping("/getById/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody CategoryPojo categoryPojo) {
        return categoryService.updateCategory(id, categoryPojo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

