package com.edu.kh.ecommerce.feature.product;

import com.edu.kh.ecommerce.feature.category.Category;
import com.edu.kh.ecommerce.feature.category.CategoryRepository;
import com.edu.kh.ecommerce.feature.product.dto.CreateProductRequest;
import com.edu.kh.ecommerce.feature.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ProductResponse createNew(CreateProductRequest createProductRequest) {

        // TODO : write your business logic
        // 1. Validate categoryID (existed or not)
        Category category = categoryRepository.findById(createProductRequest.categoryId())
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category ID not found"
                ));

        Product product =new Product();
        product.setName(createProductRequest.name());
        product.setPrice(createProductRequest.price());
        product.setQty(createProductRequest.qty());
        product.setDescription(createProductRequest.description());
        product.setCategory(category);

        // 3. System data
        product.setCode("ISTAD-PRO-001");
        product.setIsAvailable(true);

        return null;
    }
}
