package com.example.SpringCart.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {
    private String title;
    private String description;
    private BigDecimal price;
    private BigDecimal rating;
    private Long category_id;
    private String image;
}
