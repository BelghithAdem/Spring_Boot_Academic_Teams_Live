package com.firstproject.first_project.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer extends User{
    String adress;

    String city;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    List<Order> order;




}
