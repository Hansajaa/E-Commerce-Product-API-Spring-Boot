package org.clothify.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.clothify.entity.ImageEntity;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private String category;
    private Set<ImageEntity> images;
}
