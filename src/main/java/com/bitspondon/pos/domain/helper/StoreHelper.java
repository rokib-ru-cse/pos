package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Store;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class StoreHelper {

    public boolean checkAccess(Store store, User user) {
        return store.getUser().getId().equals(user.getId());
    }
}
