package com.example.SpringCart.services;

import com.example.SpringCart.repositories.CategoryRepository;
import com.example.SpringCart.schemas.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class CategorySevice {
    private final CategoryRepository categoryRepository;
    //get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    //get category by id
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow( () -> new RuntimeException("Category Not Found for id" + id) );
    }
    //create category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    //delete category
    public void deleteCategory(Long id) {
        getCategoryById(id);
        categoryRepository.deleteById(id);
    }
}
