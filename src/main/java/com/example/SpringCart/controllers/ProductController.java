package com.example.SpringCart.controllers;
import com.example.SpringCart.dtos.ProductRequestDto;
import com.example.SpringCart.dtos.ProductResponseDto;
import com.example.SpringCart.dtos.ProductWithDetailsResponseDto;
import com.example.SpringCart.schemas.Product;
import com.example.SpringCart.services.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    //getallproducts
    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }
    //getproductbyId
    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    //getproductwithdetailsbyid
    @GetMapping("/{id}/details")
    public ProductWithDetailsResponseDto getProductsWithDetailsById(@PathVariable Long id) {
      return productService.getProductWithDetailsById(id);
    }
    //getproductsbycategory
    @GetMapping("/search")
    public List<ProductWithDetailsResponseDto> getProductsByCategory(@RequestParam("categoryName") String category) {
        return productService.getProductsByCategory(category);
    }
    //createProduct
    @PostMapping
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }
    //deleteProduct
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    };
    //findUniquecategories
    @GetMapping("/categories")
    public List<String> getUniqueCategories() {
        return productService.getAllCategories();
    }
}
