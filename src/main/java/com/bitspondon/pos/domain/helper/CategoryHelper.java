package com.bitspondon.pos.domain.helper;

import com.bitspondon.pos.domain.entities.Category;
import com.bitspondon.pos.domain.entities.User;
import org.springframework.stereotype.Component;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Component
public class CategoryHelper {

    public boolean checkAccess(Category category, User user) {
        return true;
    }
}