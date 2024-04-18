package org.clothify.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.clothify.entity.ProductEntity;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Date date;
    private Double total;
    private Double discount;
    private String status;
    private String paymentMethod;
    private String shippingMethod;
    private boolean isPayed;
    private Set<ProductEntity> items;
}
