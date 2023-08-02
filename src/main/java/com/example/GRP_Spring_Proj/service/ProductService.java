package com.example.GRP_Spring_Proj.service;

import com.example.GRP_Spring_Proj.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> fetchProducts();

    Product saveProduct(Product product);

    Optional<Product> fetchProductById(Integer productId);

    Product updateProduct(Integer productId, Product product);

    void deleteProductById(Integer productId);
}
