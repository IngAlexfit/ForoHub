package com.challenge.ForoHub.alura.repository;

import com.challenge.ForoHub.alura.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}