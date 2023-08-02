package com.example.GRP_Spring_Proj.controller;

import com.example.GRP_Spring_Proj.entity.Product;
import com.example.GRP_Spring_Proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/store/products")
    public List<Product> fetchProducts()
    {
        return productService.fetchProducts();
    }

    @GetMapping(value = "/store/products/{productId}")
    public Optional<Product> fetchProducts(@PathVariable("productId") Integer productId)
    {
        return productService.fetchProductById(productId);
    }

    @PostMapping(value = "/store/products")
    public Product saveProduct(@RequestBody Product product)
    {
        return productService.saveProduct(product);
    }

    @PutMapping(value = "/store/products/{productId}")
    public Product updateProduct(@PathVariable("productId") Integer productId,@RequestBody Product product)
    {
        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/store/products/{id}")
    public String deleteProductById(@PathVariable("id") Integer productId)
    {
        productService.deleteProductById(productId);
        return "Department deleted successfully";
    }
}
