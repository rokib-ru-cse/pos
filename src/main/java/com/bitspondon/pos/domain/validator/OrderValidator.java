package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class OrderValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Order order = (Order) target;
        if (order.getTotalAmount() == null || order.getTotalAmount().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("totalAmount", "totalAmount.invalid", "Total amount must be greater than zero");
        }
        if (order.getCustomer() == null) {
            errors.rejectValue("customer", "customer.empty", "Customer must not be null");
        }
        if (order.getStore() == null) {
            errors.rejectValue("store", "store.empty", "Store must not be null");
        }
        if (order.getWarehouse() == null) {
            errors.rejectValue("warehouse", "warehouse.empty", "Warehouse must not be null");
        }
    }
}
