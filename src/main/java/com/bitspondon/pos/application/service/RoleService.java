package com.bitspondon.pos.application.service;

import com.bitspondon.pos.application.repository.RoleRepository;
import com.bitspondon.pos.domain.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role roleDetails) {
        Role role = getRoleById(id);
        if (role != null) {
            role.setName(roleDetails.getName());
            return roleRepository.save(role);
        }
        return null;
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
