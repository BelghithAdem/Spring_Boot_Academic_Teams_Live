package com.firstproject.first_project.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "\"order\"") // Escape "order" as it is a reserved word
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String ref;

    BigDecimal price; // Use BigDecimal for monetary values

    LocalDateTime date; // Use LocalDateTime instead of Date

    @ManyToOne
    @JoinColumn(name = "id_customer")
    Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_product", // Join table to link orders and products
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> products; // ManyToMany association with products
}
