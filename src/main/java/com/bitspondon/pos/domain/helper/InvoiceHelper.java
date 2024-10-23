package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Invoice;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class InvoiceHelper {

    public boolean checkAccess(Invoice invoice, User user) {
        return true;
    }
}
