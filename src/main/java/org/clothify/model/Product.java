package org.clothify.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String productID;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private String category;
}
