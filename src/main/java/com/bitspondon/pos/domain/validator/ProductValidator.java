package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if (product.getName() == null || product.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Product name must not be empty");
        }
        if (product.getDescription() == null || product.getDescription().isEmpty()) {
            errors.rejectValue("description", "description.empty", "Description must not be empty");
        }
        if (product.getUnitPrice() == null || product.getUnitPrice().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("unitPrice", "unitPrice.invalid", "Unit price must be greater than zero");
        }
        if (product.getStockQuantity() < 0) {
            errors.rejectValue("stockQuantity", "stockQuantity.invalid", "Stock quantity cannot be negative");
        }
    }
}
