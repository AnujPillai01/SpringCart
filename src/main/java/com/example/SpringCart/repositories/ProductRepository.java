package com.example.SpringCart.repositories;

import com.example.SpringCart.dtos.ProductResponseDto;
import com.example.SpringCart.schemas.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_Name(String category);

    @Query(value = "SELECT DISTINCT p.category.name FROM Product p")
    List<String> findAllCategories();

    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.id = :id")
    Product findProductWithDetailsById(Long id);
}
