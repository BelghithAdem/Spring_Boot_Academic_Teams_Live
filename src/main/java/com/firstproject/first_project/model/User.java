package com.firstproject.first_project.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "\"user\"") // Échappe le mot réservé user
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    long id;

    String name;

    String salary;

    Long phone;

    Long age;

    String email;

    String password;
}
