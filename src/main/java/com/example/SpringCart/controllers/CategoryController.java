package com.example.SpringCart.controllers;

import com.example.SpringCart.dtos.CategoryRequestDto;
import com.example.SpringCart.schemas.Category;
import com.example.SpringCart.services.CategorySevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategorySevice categorySevice;

    @GetMapping
    public List<Category> getAllCategories() {
        return categorySevice.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable  Long id) {
        return categorySevice.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        return categorySevice.createCategory(categoryRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categorySevice.deleteCategory(id);
    }
}
