package com.edu.kh.ecommerce.exception;

public record FieldResponse(
        String field,
        String reason
) {
}
