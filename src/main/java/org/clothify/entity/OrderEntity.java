package org.clothify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Double total;
    private Double discount;
    private String status;
    private String paymentMethod;
    private String shippingMethod;
    private boolean isPayed;

    @ManyToMany
    @JoinTable(name = "order_detail",
    joinColumns = {
            @JoinColumn(name = "order_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "item_id")
    })
    private Set<ProductEntity> items;
}
