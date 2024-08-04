package org.clothify.Service;

import org.clothify.entity.OrderDetail;
import org.clothify.entity.OrderEntity;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {
    OrderEntity createOrder(Order order);
    Set<OrderDetail> saveOrderDetail(OrderEntity order, ProductEntity[] products);
    OrderEntity updateOrder(Set<OrderDetail> orderDetails, OrderEntity order);
    List<OrderEntity> getOrders();
}
