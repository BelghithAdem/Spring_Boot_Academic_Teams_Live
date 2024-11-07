package com.firstproject.first_project.Repository;

import com.firstproject.first_project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}


