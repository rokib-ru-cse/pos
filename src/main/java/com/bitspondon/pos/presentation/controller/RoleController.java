package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.RoleService;
import com.bitspondon.pos.domain.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping
    public ResponseEntity<Role> getRoleById(@RequestParam Long roleId) {
        Role role = roleService.getRoleById(roleId);

        return role != null ? ResponseEntity.ok(role) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.createRole(role);

        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestParam Long roleId, @RequestBody Role roleDetails) {
        Role updatedRole = roleService.updateRole(roleId, roleDetails);

        return updatedRole != null ? ResponseEntity.ok(updatedRole) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteRole(@RequestParam Long roleId) {
        roleService.deleteRole(roleId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}