package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Category;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class CategoryValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Category category = (Category) target;
        if (category.getName() == null || category.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Category name must not be empty");
        }
    }
}
