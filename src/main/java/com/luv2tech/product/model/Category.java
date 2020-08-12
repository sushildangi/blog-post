package com.luv2tech.product.model;

import com.luv2tech.model.base.BaseAudit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@ToString
@Table(name = "category")
public class Category extends BaseAudit<String> {
    @Column(name = "name", nullable = false)
    private String name;
    @Lob
    @Column(name = "description", nullable = false)
    private String description;
}
