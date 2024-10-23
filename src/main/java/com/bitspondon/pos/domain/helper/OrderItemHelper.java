package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.OrderItem;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class OrderItemHelper {

    public boolean checkAccess(OrderItem orderItem, User user) {
        return true;
    }
}
