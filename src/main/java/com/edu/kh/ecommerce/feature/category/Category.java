package com.edu.kh.ecommerce.feature.category;

import com.edu.kh.ecommerce.feature.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// Make POJO = plain Old Java Object
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name; // Default String = 255 characterss

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
