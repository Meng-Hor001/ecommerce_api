package com.edu.kh.ecommerce.feature.product.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Integer code,
        String name,
        BigDecimal price,
        Integer qty,
        String description,
        Boolean isAvailable,
        String categoryName
) {
}
