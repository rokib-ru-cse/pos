package com.bitspondon.pos.application.repository;

import com.bitspondon.pos.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
