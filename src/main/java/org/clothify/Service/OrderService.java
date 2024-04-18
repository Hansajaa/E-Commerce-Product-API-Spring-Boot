package org.clothify.Service;

import org.clothify.entity.OrderEntity;
import org.clothify.model.Order;

public interface OrderService {
    OrderEntity createOrder(Order order);
}
