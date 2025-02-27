package com.challenge.ForoHub.alura.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Category() {
        // Default constructor
    }

    public Category(String name) {
        this.name = name;
    }
}