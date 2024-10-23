package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.StoreService;
import com.bitspondon.pos.domain.entities.Store;
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
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/list")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping
    public ResponseEntity<Store> getStoreById(@RequestParam Long storeId) {
        Store store = storeService.getStoreById(storeId);

        return store != null ? ResponseEntity.ok(store) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store createdStore = storeService.createStore(store);

        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Store> updateStore(@RequestParam Long storeId, @RequestBody Store storeDetails) {
        Store updatedStore = storeService.updateStore(storeId, storeDetails);

        return updatedStore != null ? ResponseEntity.ok(updatedStore) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteStore(@RequestParam Long storeId) {
        storeService.deleteStore(storeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}