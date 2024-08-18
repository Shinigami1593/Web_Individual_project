package com.example.lilyclothing.Controller;

import com.example.lilyclothing.Entity.Product;
import com.example.lilyclothing.Pojo.ProductPojo;
import com.example.lilyclothing.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public void save(@RequestBody ProductPojo productPojo) {
        productService.saveData(productPojo);
    }

    @GetMapping("/getById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductPojo productPojo) {
        return productService.updateProduct(id, productPojo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}


