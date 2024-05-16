package com.example.internetpetshop.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "product_id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID Id;

    @Column
    private String name;

    @Column(name = "picture_url" ,columnDefinition = "TEXT")
    private String pictureUrl;


    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    public Product(String name,
                   String pictureUrl,
                   String description,
                   BigDecimal price,
                   Category category) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        return Id == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
