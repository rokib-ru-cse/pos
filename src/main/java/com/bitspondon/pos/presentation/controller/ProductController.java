package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.ProductService;
import com.bitspondon.pos.domain.entities.Product;
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
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping
    public ResponseEntity<Product> getProductById(@RequestParam Long productId) {
        Product product = productService.getProductById(productId);

        return product != null ? ResponseEntity.ok(product) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestParam Long productId, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(productId, productDetails);

        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestParam Long productId) {
        productService.deleteProduct(productId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}