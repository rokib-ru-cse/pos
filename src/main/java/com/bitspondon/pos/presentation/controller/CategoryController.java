package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.CategoryService;
import com.bitspondon.pos.domain.entities.Category;
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
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping
    public ResponseEntity<Category> getCategoryById(@RequestParam Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return category != null ? ResponseEntity.ok(category) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestParam Long categoryId, @RequestBody Category categoryDetails) {
        Category updatedCategory = categoryService.updateCategory(categoryId, categoryDetails);
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteCategory(@RequestParam Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
