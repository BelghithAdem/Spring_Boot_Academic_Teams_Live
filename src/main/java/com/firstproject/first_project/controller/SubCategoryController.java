package com.firstproject.first_project.controller;

import com.firstproject.first_project.model.SubCategory;
import com.firstproject.first_project.Services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    // Get all subcategories
    @GetMapping
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    // Get subcategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Long id) {
        Optional<SubCategory> subCategory = subCategoryService.getSubCategoryById(id);
        return subCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new subcategory
    @PostMapping
    public SubCategory createSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.createSubCategory(subCategory);
    }

    // Update subcategory
    @PutMapping("/{id}")
    public ResponseEntity<SubCategory> updateSubCategory(@PathVariable Long id, @RequestBody SubCategory subCategoryDetails) {
        SubCategory updatedSubCategory = subCategoryService.updateSubCategory(id, subCategoryDetails);
        return ResponseEntity.ok(updatedSubCategory);
    }

    // Delete subcategory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable Long id) {
        subCategoryService.deleteSubCategory(id);
        return ResponseEntity.noContent().build();
    }
}
