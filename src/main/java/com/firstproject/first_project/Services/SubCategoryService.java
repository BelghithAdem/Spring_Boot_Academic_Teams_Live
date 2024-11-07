package com.firstproject.first_project.Services;


import com.firstproject.first_project.model.SubCategory;
import com.firstproject.first_project.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public Optional<SubCategory> getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id);
    }

    public SubCategory createSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public SubCategory updateSubCategory(Long id, SubCategory subCategoryDetails) {
        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("SubCategory not found"));
        subCategory.setTitle(subCategoryDetails.getTitle());
        subCategory.setDescription(subCategoryDetails.getDescription());
        subCategory.setCategory(subCategoryDetails.getCategory());
        subCategory.setProduct(subCategoryDetails.getProduct());
        return subCategoryRepository.save(subCategory);
    }

    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }
}
