package com.edu.kh.ecommerce.feature.orderLine;

import com.edu.kh.ecommerce.feature.order.Order;
import com.edu.kh.ecommerce.feature.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_lines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderLineId;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private Float discount;
}

