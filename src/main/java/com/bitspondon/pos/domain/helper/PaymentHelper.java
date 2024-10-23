package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Payment;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class PaymentHelper {

    public boolean checkAccess(Payment payment, User user) {
        return true;
    }
}
