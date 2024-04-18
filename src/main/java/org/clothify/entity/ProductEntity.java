package org.clothify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Item")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private String category;

    @ManyToMany
    @JoinTable(name = "product_image",
    joinColumns = {
            @JoinColumn(name = "product_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "image_id")
    })
    private Set<ImageEntity> images;

    @ManyToMany(mappedBy = "items")
    private Set<OrderEntity> orders;
}