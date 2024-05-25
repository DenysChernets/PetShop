package com.example.internetpetshop.Controllers;

import com.example.internetpetshop.Models.Cart;
import com.example.internetpetshop.Models.CartManager;
import com.example.internetpetshop.Models.Product;
import com.example.internetpetshop.Services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartManager cartManager;
    private final ProductService productService;

    @Autowired
    public CartController(CartManager cartManager, ProductService productService) {
        this.cartManager = cartManager;
        this.productService = productService;
    }

    @GetMapping
    public String getCart(Model model, HttpSession session) {
        model.addAttribute("cart", cartManager.getCart(session));
        return "cart";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, @RequestParam("id") Product product,
                      @RequestParam(value = "qty", required = false, defaultValue = "1") int qty) {
        Cart cart = cartManager.getCart(session);
        cart.addItem(product, qty);
        return "redirect:/home";
    }

    @RequestMapping("/remove")
    public String remove(HttpSession session, @RequestParam("id") UUID id) {
        Product product = productService.findById(id).get();
        Cart cart = cartManager.getCart(session);
        cart.removeItem(product);
        return "redirect:/cart";
    }

    @RequestMapping("/update")
    public String update(HttpSession session, @RequestParam("id") UUID id, @RequestParam("qty") int qty) {
        Product product = productService.findById(id).get();
        Cart cart = cartManager.getCart(session);
        cart.updateItem(product, qty);
        return "redirect:/cart";
    }
}