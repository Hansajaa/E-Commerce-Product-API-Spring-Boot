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
    private String userName;
    private String date;
    private Double total;
    private Double discount;
    private String status;
    private String paymentMethod;
    private String shippingMethod;
    private String shippingAddress1;
    private String shippingAddress2;
    private String postalCode;
    private boolean isPaid;
    private Set<ProductEntity> items;
}
