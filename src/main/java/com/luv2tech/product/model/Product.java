package com.luv2tech.product.model;

import com.luv2tech.model.base.BaseAudit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Setter
@Getter
@ToString
public class Product extends BaseAudit<String> {
    @Column(nullable = false, name = "name")
    private String name;
    @Lob
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "stock", nullable = false)
    private Long stock;
    @Column(name = "image", nullable = false)
    private String image;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
