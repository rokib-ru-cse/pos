package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.SupplierService;
import com.bitspondon.pos.domain.entities.Supplier;
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
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/list")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping
    public ResponseEntity<Supplier> getSupplierById(@RequestParam Long supplierId) {
        Supplier supplier = supplierService.getSupplierById(supplierId);

        return supplier != null ? ResponseEntity.ok(supplier) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier createdSupplier = supplierService.createSupplier(supplier);

        return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<Supplier> updateSupplier(@RequestParam Long supplierId, @RequestBody Supplier supplierDetails) {
        Supplier updatedSupplier = supplierService.updateSupplier(supplierId, supplierDetails);

        return updatedSupplier != null ? ResponseEntity.ok(updatedSupplier) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteSupplier(@RequestParam Long supplierId) {
        supplierService.deleteSupplier(supplierId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
