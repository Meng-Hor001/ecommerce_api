package com.edu.kh.ecommerce.feature.product;

import com.edu.kh.ecommerce.feature.product.dto.CreateProductRequest;
import com.edu.kh.ecommerce.feature.product.dto.ProductResponse;
import com.edu.kh.ecommerce.feature.product.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductResponse createNew(CreateProductRequest createProductRequest);

    Page<ProductResponse> getProducts(int pageSize, int pageNumber);

    ProductResponse updateProductByCode(String code, UpdateProductRequest updateProductRequest);


    ProductResponse getProductByCode(String code);
}
