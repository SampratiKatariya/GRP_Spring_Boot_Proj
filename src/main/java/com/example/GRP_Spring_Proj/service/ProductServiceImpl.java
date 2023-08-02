package com.example.GRP_Spring_Proj.service;

import com.example.GRP_Spring_Proj.entity.Product;
import com.example.GRP_Spring_Proj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> fetchProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> fetchProductById(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product updateProduct(Integer productId, Product product) {
        Product updatedProduct=productRepository.findById(productId).get();
        if(Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName()))
            updatedProduct.setProductName(product.getProductName());

        if(Objects.nonNull(product.getProductDescription()) && !"".equalsIgnoreCase(product.getProductDescription()))
            updatedProduct.setProductDescription(product.getProductDescription());

        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productRepository.deleteById(productId);
    }


}
