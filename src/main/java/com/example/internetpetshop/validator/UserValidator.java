package com.example.internetpetshop.validator;

import com.example.internetpetshop.Models.User;
import com.example.internetpetshop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        //Username and password can't be empty or contain whitespace
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "This field can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "This field can`t be empty");

        // Username must have from 4 characters to 32
        if (user.getUsername().length() < 4)
            errors.rejectValue("username", "Username must have more than 4 characters");

        if (user.getUsername().length() > 32)
            errors.rejectValue("username", "Username must have less than 32 characters");

        //Username can't be duplicated
        if (userService.findByUserName(user.getUsername()) != null) {
            errors.rejectValue("username", "Username can't be duplicated");
        }
        //Email can't be duplicated
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Email can't be duplicated");
        }
        //Password must have at least 8 characters and max 32
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "Password must have more than 8 characters");
        }
        if (user.getPassword().length() > 32) {
            errors.rejectValue("password", "Password must have less than 32 characters");
        }
        //Password must be the same as the confirmation password
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Password must be the same as the confirmation password");
        }
        //Age needs to be higher than 13
        if (user.getAge() <= 13) {
            errors.rejectValue("age", "Age needs to be higher than 13");
        }


    }
}

