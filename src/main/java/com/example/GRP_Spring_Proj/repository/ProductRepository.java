package com.example.GRP_Spring_Proj.repository;

import com.example.GRP_Spring_Proj.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
