package com.bitspondon.pos.application.service;

import com.bitspondon.pos.application.repository.WarehouseRepository;
import com.bitspondon.pos.domain.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(Long id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        warehouse.setCreatedAt(LocalDateTime.now());
        return warehouseRepository.save(warehouse);
    }

    public Warehouse updateWarehouse(Long id, Warehouse warehouseDetails) {
        Warehouse warehouse = getWarehouseById(id);
        if (warehouse != null) {
            warehouse.setName(warehouseDetails.getName());
            warehouse.setLocation(warehouseDetails.getLocation());
            warehouse.setStore(warehouseDetails.getStore());
            return warehouseRepository.save(warehouse);
        }
        return null;
    }

    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }
}
