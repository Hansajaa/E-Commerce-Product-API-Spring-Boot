package org.clothify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_detail")
public class OrderDetail {

    @EmbeddedId
    OrderDetailKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    OrderEntity order;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    ProductEntity product;

    int qty;

}
