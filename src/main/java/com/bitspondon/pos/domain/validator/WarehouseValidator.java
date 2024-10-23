package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Warehouse;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class WarehouseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Warehouse.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Warehouse warehouse = (Warehouse) target;
        if (warehouse.getName() == null || warehouse.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Warehouse name must not be empty");
        }
        if (warehouse.getLocation() == null || warehouse.getLocation().isEmpty()) {
            errors.rejectValue("location", "location.empty", "Location must not be empty");
        }
        if (warehouse.getStore() == null) {
            errors.rejectValue("store", "store.null", "Store must be specified");
        }
    }
}