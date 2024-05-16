package com.example.internetpetshop.Services;

import com.example.internetpetshop.Models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
    Category findByCategoryName(String category);
    Category findByCategoryId(UUID id);
}
