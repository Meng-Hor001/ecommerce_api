package com.edu.kh.ecommerce.feature.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank( message = "Name is required")
        @Size(min = 1 , max = 100)
        String name,

        @NotNull(message = "Price is required")
        @Positive
        BigDecimal price,

        @NotNull(message = "qty is required")
        @Positive
        Integer qty,

        String description,

        @NotNull(message = "categoryId is required")
        @Positive
        Integer categoryId
) {
}
