package com.challenge.ForoHub.alura.controller;

import com.challenge.ForoHub.alura.model.Category;
import com.challenge.ForoHub.alura.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/cargar-prueba")
    public ResponseEntity<?> cargarCategoriasDePrueba() {
        List<Category> categoriasDePrueba = Arrays.asList(
                new Category("Categoria 1"),
                new Category("Categoria 2"),
                new Category("Categoria 3")
        );

        for (Category categoria : categoriasDePrueba) {
            categoryService.save(categoria);
        }

        return ResponseEntity.ok("Categorías de prueba cargadas exitosamente");
    }
}