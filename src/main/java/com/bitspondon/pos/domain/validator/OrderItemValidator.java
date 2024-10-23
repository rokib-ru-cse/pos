package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.OrderItem;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class OrderItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return OrderItem.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderItem orderItem = (OrderItem) target;
        if (orderItem.getQuantity() <= 0) {
            errors.rejectValue("quantity", "quantity.invalid", "Quantity must be greater than zero");
        }
        if (orderItem.getPrice() == null || orderItem.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("price", "price.invalid", "Price must be greater than zero");
        }
        if (orderItem.getProduct() == null) {
            errors.rejectValue("product", "product.empty", "Product must not be null");
        }
    }
}
