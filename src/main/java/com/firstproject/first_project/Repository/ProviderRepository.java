package com.firstproject.first_project.Repository;

import com.firstproject.first_project.Entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}