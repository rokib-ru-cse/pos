package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Store;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class StoreValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Store.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Store store = (Store) target;
        if (store.getName() == null || store.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Store name must not be empty");
        }
        if (store.getAddress() == null || store.getAddress().isEmpty()) {
            errors.rejectValue("address", "address.empty", "Store address must not be empty");
        }
        if (store.getPhoneNumber() == null || store.getPhoneNumber().isEmpty()) {
            errors.rejectValue("phoneNumber", "phoneNumber.empty", "Phone number must not be empty");
        }
    }
}
