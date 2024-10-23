package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Order;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class OrderHelper {

    public boolean checkAccess(Order order, User user) {
        return true;
    }
}
