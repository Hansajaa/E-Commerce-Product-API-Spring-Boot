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
    private String productID;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private String category;
    private String imageUrl;
    private int cartQty;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;
}
