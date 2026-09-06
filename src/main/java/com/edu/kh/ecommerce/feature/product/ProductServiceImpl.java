package com.edu.kh.ecommerce.feature.product;

import com.edu.kh.ecommerce.feature.category.Category;
import com.edu.kh.ecommerce.feature.category.CategoryRepository;
import com.edu.kh.ecommerce.feature.product.dto.CreateProductRequest;
import com.edu.kh.ecommerce.feature.product.dto.ProductResponse;
import com.edu.kh.ecommerce.util.GenerateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;


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
        product.setCode(GenerateUtil.RandomProductCode());
        product.setIsAvailable(true);


        // 4. Save into database
        product = productRepository.save(product);

        // 5. Transfer data from Entity to DTO
        return productMapper.productToProductResponse(product);
    }

    @Override
    public Page<ProductResponse> getProducts(int pageSize, int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageable)
                .map(productMapper::productToProductResponse);
    }
}
