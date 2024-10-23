package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Product;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class ProductHelper {

    public boolean checkAccess(Product product, User user) {
        return true;
    }
}
