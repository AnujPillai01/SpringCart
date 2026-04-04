package com.example.SpringCart.services;

import com.example.SpringCart.dtos.ProductRequestDto;
import com.example.SpringCart.dtos.ProductResponseDto;
import com.example.SpringCart.dtos.ProductWithDetailsResponseDto;
import com.example.SpringCart.repositories.CategoryRepository;
import com.example.SpringCart.repositories.ProductRepository;
import com.example.SpringCart.schemas.Category;
import com.example.SpringCart.schemas.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategorySevice categorySevice;

    //getallproducts
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product->
            ProductResponseDto.builder()
                    .id(product.getId())
                    .title(product.getTitle())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .rating(product.getRating())
                    .image(product.getImage())
                    .build()
        ).toList();
    }
    //getproductbyid
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found with id: " + id));

        return ProductResponseDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .rating(product.getRating())
                .image(product.getImage())
                .build();
    }

    //getProductsWithDetailsById
    public ProductWithDetailsResponseDto getProductWithDetailsById(Long id){
        Product product = productRepository.findProductWithDetailsById(id);

        return ProductWithDetailsResponseDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .category(product.getCategory().getName())
                .price(product.getPrice())
                .rating(product.getRating())
                .image(product.getImage())
                .build();
    }

    //createproduct
    public Product createProduct(ProductRequestDto productRequestDto) {
        Category category = categorySevice.getCategoryById(productRequestDto.getCategoryId());

        Product product = Product.builder()
                .title(productRequestDto.getTitle())
                .category(category)
                .description(productRequestDto.getDescription())
                .image(productRequestDto.getImage())
                .price(productRequestDto.getPrice())
                .rating(productRequestDto.getRating())
                .build();
       return productRepository.save(product);
    }

    //delete product
    public void deleteProduct(Long id){
        getProductById(id);
        productRepository.deleteById(id);
    }

    //get products by category
    public List<ProductWithDetailsResponseDto> getProductsByCategory(String category){
        List<Product> products = productRepository.findByCategory_Name(category);

        return  products.stream().map(product ->
            ProductWithDetailsResponseDto.builder()
                    .id(product.getId())
                    .title(product.getTitle())
                    .description(product.getDescription())
                    .category(product.getCategory().getName())
                    .price(product.getPrice())
                    .rating(product.getRating())
                    .image(product.getImage())
                    .build()
        ).toList();
    }

    //get all categories
    public List<String> getAllCategories(){
        return productRepository.findAllCategories();
    }
}
