package com.example.internetpetshop.Controllers;

import com.example.internetpetshop.Models.User;
import com.example.internetpetshop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/user/edit")
    public String editUserForm(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        return "edit_user";
    }

    @PostMapping("/user")
    public String updateUser(Principal principal, @ModelAttribute("user") User user) {
        User existingUser = userService.findByUserName(principal.getName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setCity(user.getCity());
        existingUser.setBalance(user.getBalance());
        existingUser.setGender(user.getGender());
        userService.editUser(existingUser);

        return "redirect:/home";
    }
}