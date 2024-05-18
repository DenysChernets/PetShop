package com.example.internetpetshop.Controllers;

import com.example.internetpetshop.Models.User;
import com.example.internetpetshop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String UserPanel(Principal principal, Model model) {
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("user", user);
        if (user != null) {
            model.addAttribute("user", user);
        } else {
            return "error";
        }
        return "account";
    }
}