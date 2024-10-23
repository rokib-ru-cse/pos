package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Role;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class RoleHelper {

    public boolean checkAccess(Role role, String requiredPermission) {
        return role.getName().equals(requiredPermission);
    }
}
