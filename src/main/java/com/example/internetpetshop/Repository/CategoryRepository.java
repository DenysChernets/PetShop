package com.example.internetpetshop.Repository;

import com.example.internetpetshop.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByCategoryName(String name);
}
