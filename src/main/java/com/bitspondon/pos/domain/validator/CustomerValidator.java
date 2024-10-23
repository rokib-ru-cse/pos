package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if (customer.getName() == null || customer.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Customer name must not be empty");
        }
        if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
            errors.rejectValue("email", "email.empty", "Email must not be empty");
        }
        if (customer.getPhoneNumber() == null || customer.getPhoneNumber().isEmpty()) {
            errors.rejectValue("phoneNumber", "phoneNumber.empty", "Phone number must not be empty");
        }
    }
}
