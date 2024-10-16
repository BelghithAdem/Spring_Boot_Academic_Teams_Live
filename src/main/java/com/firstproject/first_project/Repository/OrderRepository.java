package com.firstproject.first_project.Repository;

import com.firstproject.first_project.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

