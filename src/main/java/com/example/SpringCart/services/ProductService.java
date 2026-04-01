package com.example.SpringCart.services;

import com.example.SpringCart.dtos.ProductRequestDto;
import com.example.SpringCart.dtos.ProductResponseDto;
import com.example.SpringCart.repositories.ProductRepository;
import com.example.SpringCart.schemas.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    //getallproducts
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    //getproductbyid
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found with id: " + id));
    }

    //createproduct
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = Product.builder()
                .title(productRequestDto.getTitle())
                .category(productRequestDto.getCategory())
                .description(productRequestDto.getDescription())
                .image(productRequestDto.getImage())
                .price(productRequestDto.getPrice())
                .rating(productRequestDto.getRating())
                .build();
        Product savedProduct = productRepository.save(product);
        return ProductResponseDto.builder()
                .id(savedProduct.getId())
                .title(savedProduct.getTitle())
                .description(savedProduct.getDescription())
                .category(savedProduct.getCategory())
                .price(savedProduct.getPrice())
                .rating(savedProduct.getRating())
                .image(savedProduct.getImage())
                .build();
    }

    //delete product
    public void deleteProduct(Long id){
        getProductById(id);
        productRepository.deleteById(id);
    }
}
