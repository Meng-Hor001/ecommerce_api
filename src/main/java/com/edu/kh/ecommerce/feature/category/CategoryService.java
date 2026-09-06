package com.edu.kh.ecommerce.feature.category;

import com.edu.kh.ecommerce.feature.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;

public interface CategoryService {

    Page<CategoryResponse> findAll(int pageNumber, int pageSize);
}
