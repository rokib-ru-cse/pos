package com.bitspondon.pos.domain.validator;

import com.bitspondon.pos.domain.entities.Role;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class RoleValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Role.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Role role = (Role) target;
        if (role.getName() == null || role.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Role name must not be empty");
        }
    }
}
