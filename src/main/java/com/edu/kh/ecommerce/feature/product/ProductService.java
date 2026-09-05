package com.edu.kh.ecommerce.feature.product;

import com.edu.kh.ecommerce.feature.product.dto.CreateProductRequest;
import com.edu.kh.ecommerce.feature.product.dto.ProductResponse;

public interface ProductService {
    ProductResponse createNew(CreateProductRequest createProductRequest);
}
