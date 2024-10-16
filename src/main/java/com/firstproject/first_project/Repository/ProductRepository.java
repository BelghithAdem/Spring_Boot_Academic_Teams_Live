package com.firstproject.first_project.Repository;

import com.firstproject.first_project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}