package com.example.internetpetshop.Controllers;

import com.example.internetpetshop.Models.Product;
import com.example.internetpetshop.Models.UserRole;
import com.example.internetpetshop.Services.CategoryService;
import com.example.internetpetshop.Services.ProductService;
import com.example.internetpetshop.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ProductValidator productValidator;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService,
                             ProductValidator productValidator,
                             CategoryService categoryService) {
        this.productService = productService;
        this.productValidator = productValidator;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String products(Model model) {
        UserRole admin = UserRole.ADMIN;
        model.addAttribute("admin",admin);
        model.addAttribute("products", getAllProducts());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable UUID id, Model model) {
        Product product = productService.findById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("products", getAllProducts());
        model.addAttribute("featuredProds", getFourProdForCategory(product.getCategory().getCategoryName()));
        return "product";
    }

    @RequestMapping("/products/search")
    public String getSearchProds(@RequestParam("search") String searchTemplate, Model model){
        List<Product> foundProds = productService.findAllBySearchKey(searchTemplate);
        model.addAttribute("searchQuery", searchTemplate);
        model.addAttribute("foundProds", foundProds);
        return "search-products";
    }

    @GetMapping("products/{category}")
    public String getCategoryProducts(@PathVariable String category, Model model) {
        model.addAttribute("categoryProducts", getAllProductsByCategory(category));
        model.addAttribute("category", category);
        return "category-products";
    }
    private List<Product> getFourProdForCategory(String category) {
        int i = 4;
        List<Product> products = productService.findAll();
        List<Product> featuredProducts = new ArrayList<>(4);
        for (Product product : products) {
            if (product.getCategory().getCategoryName().equals(category)) {
                if (i > 0) {
                    featuredProducts.add(product);
                    i--;
                }
            }

        }
        return featuredProducts;
    }
    private List<Product> getAllProducts() {
        return productService.findAll();
    }
    private List<Product> getAllProductsByCategory(String name) {
        return productService.findAllByCategoryName(name);
    }

}
