package com.example.internetpetshop.validator;

import com.example.internetpetshop.Models.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","This field can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "This field can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "This field can`t be empty");

        // Name must have from 2 characters to 32
        if (product.getName().length() <= 1) {
            errors.rejectValue("name", "Name must have more than 2 characters");
        }
        if (product.getName().length() > 32) {
            errors.rejectValue("name", "Name must have less than 32 character");
        }
    }
}
