package com.edu.kh.ecommerce.feature.product;

import com.edu.kh.ecommerce.feature.product.dto.CreateProductRequest;
import com.edu.kh.ecommerce.feature.product.dto.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse createNew(@Valid @RequestBody CreateProductRequest createProductRequest){
        log.info("Create New {}", createProductRequest);
        return productService.createNew(createProductRequest);
    }
}
