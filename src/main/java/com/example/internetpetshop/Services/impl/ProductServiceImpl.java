package com.example.internetpetshop.Services.impl;

import com.example.internetpetshop.Models.Product;
import com.example.internetpetshop.Repository.ProductRepository;
import com.example.internetpetshop.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(UUID id, Product newProduct) {
        Product found = productRepository.findById(id).get();
        found.setName(newProduct.getName());
        found.setPictureUrl(newProduct.getPictureUrl());
        found.setDescription(newProduct.getDescription());
        found.setPrice(newProduct.getPrice());
        save(newProduct);
    }

    @Override
    public void delete(UUID id) {
        productRepository.delete(findById(id).get());
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByCategory(UUID Id) {
        return productRepository.findAllByCategory(Id);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public List<Product> findAllByCategoryName(String category){
        List<Product> products = productRepository.findAll();
        List<Product> categoryProducts = new ArrayList<>();
        for (Product product:products) {
            if(product.getCategory().getCategoryName().equals(category))
                categoryProducts.add(product);
        }
        return categoryProducts;
    }

    @Override
    public List<Product> findAllBySearchKey(String key) {
        return productRepository.findByNameContainingIgnoreCase(key);
    }
}
