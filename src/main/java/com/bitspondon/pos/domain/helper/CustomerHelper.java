package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Customer;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class CustomerHelper {

    public boolean checkAccess(Customer customer, User user) {
        return true;
    }
}