package com.example.internetpetshop.Repository;

import com.example.internetpetshop.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findById(UUID id);
    Product findByName(String name);
    List<Product> findAll();
    List<Product> findAllByCategory(UUID Id);
    List<Product> findByNameContainingIgnoreCase(String key);

}