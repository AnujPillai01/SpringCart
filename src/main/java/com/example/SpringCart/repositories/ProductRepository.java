package com.example.SpringCart.repositories;

import com.example.SpringCart.schemas.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
