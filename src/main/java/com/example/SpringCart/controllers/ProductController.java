package com.example.SpringCart.controllers;
import com.example.SpringCart.dtos.ProductRequestDto;
import com.example.SpringCart.dtos.ProductResponseDto;
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
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    //getproductbyId
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    //getproductwithdetailsbyid
    //getproductsbycategory
    //createProduct
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }
    //deleteProduct
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    };
    //findUniquecategories
}
