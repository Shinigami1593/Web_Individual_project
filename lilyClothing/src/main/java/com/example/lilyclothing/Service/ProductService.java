package com.example.lilyclothing.Service;


import com.example.lilyclothing.Entity.Product;
import com.example.lilyclothing.Pojo.ProductPojo;

import java.util.List;

public interface ProductService {
    void saveData(ProductPojo productPojo);
    Product getProductById(Long productId);
    List<Product> getAllProducts();
    Product updateProduct(Long id, ProductPojo productPojo);
    void deleteProduct(Long id);
}

