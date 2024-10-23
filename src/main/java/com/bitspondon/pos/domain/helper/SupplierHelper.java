package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Supplier;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class SupplierHelper {

    public boolean checkAccess(Supplier supplier, User user) {
        return true;
    }
}
