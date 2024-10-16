package com.firstproject.first_project.repository;

import com.firstproject.first_project.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface CategoryRepository extends JpaRepository<Category, Long> {


        // Find categories by title
    List<Category> findByTitre(String titre);

    // Find categories by description and title
    List<Category> findCategoryByDescriptionAndTitre(String description, String titre);
}
