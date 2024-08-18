package com.example.lilyclothing.Service.ServiceImpl;

import com.example.lilyclothing.Entity.Product;
import com.example.lilyclothing.Pojo.ProductPojo;
import com.example.lilyclothing.Repository.ProductRepository;
import com.example.lilyclothing.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void saveData(ProductPojo productPojo) {
        Product product = new Product();
        product.setName(productPojo.getName());
        product.setDescription(productPojo.getDescription());
        product.setPrice(productPojo.getPrice());
        product.setStockQuantity(productPojo.getStockQuantity());
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, ProductPojo productPojo) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productPojo.getName());
        product.setDescription(productPojo.getDescription());
        product.setPrice(productPojo.getPrice());
        product.setStockQuantity(productPojo.getStockQuantity());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

