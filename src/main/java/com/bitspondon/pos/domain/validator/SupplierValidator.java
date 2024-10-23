package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Supplier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class SupplierValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Supplier.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Supplier supplier = (Supplier) target;
        if (supplier.getName() == null || supplier.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Supplier name must not be empty");
        }
        if (supplier.getEmail() == null || supplier.getEmail().isEmpty()) {
            errors.rejectValue("email", "email.empty", "Email must not be empty");
        }
        if (supplier.getPhoneNumber() == null || supplier.getPhoneNumber().isEmpty()) {
            errors.rejectValue("phoneNumber", "phoneNumber.empty", "Phone number must not be empty");
        }
        if (supplier.getAddress() == null || supplier.getAddress().isEmpty()) {
            errors.rejectValue("address", "address.empty", "Address must not be empty");
        }
    }
}
