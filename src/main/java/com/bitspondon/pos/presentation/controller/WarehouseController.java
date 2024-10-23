package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.WarehouseService;
import com.bitspondon.pos.domain.entities.Warehouse;
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
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/list")
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping
    public ResponseEntity<Warehouse> getWarehouseById(@RequestParam Long warehouseId) {
        Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
        return warehouse != null ? ResponseEntity.ok(warehouse) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse createdWarehouse = warehouseService.createWarehouse(warehouse);

        return new ResponseEntity<>(createdWarehouse, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Warehouse> updateWarehouse(@RequestParam Long warehouseId, @RequestBody Warehouse warehouseDetails) {
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(warehouseId, warehouseDetails);

        return updatedWarehouse != null ? ResponseEntity.ok(updatedWarehouse) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteWarehouse(@RequestParam Long warehouseId) {
        warehouseService.deleteWarehouse(warehouseId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
