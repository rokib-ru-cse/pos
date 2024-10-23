package com.bitspondon.pos.application.service;

import com.bitspondon.pos.application.repository.StoreRepository;
import com.bitspondon.pos.domain.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    public Store createStore(Store store) {
        store.setCreatedAt(LocalDateTime.now());
        return storeRepository.save(store);
    }

    public Store updateStore(Long id, Store storeDetails) {
        Store store = getStoreById(id);
        if (store != null) {
            store.setName(storeDetails.getName());
            store.setAddress(storeDetails.getAddress());
            store.setPhoneNumber(storeDetails.getPhoneNumber());
            store.setUser(storeDetails.getUser());
            return storeRepository.save(store);
        }
        return null;
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}
