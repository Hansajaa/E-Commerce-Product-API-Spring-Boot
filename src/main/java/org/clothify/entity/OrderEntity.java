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
    private String userName;
    private String date;
    private Double total;
    private Double discount;
    private String status;
    private String paymentMethod;
    private String shippingAddress1;
    private String shippingAddress2;
    private String postalCode;
    private String shippingMethod;
    private boolean isPaid;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
}
