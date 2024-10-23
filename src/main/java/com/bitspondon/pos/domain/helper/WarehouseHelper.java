package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.User;
import com.bitspondon.pos.domain.entities.Warehouse;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class WarehouseHelper {

    public boolean checkAccess(Warehouse warehouse, User user) {
        return warehouse.getStore().getUser().getId().equals(user.getId());
    }
}
