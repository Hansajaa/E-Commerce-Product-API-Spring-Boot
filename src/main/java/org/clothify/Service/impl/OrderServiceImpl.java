package org.clothify.Service.impl;

import lombok.RequiredArgsConstructor;
import org.clothify.Service.OrderService;
import org.clothify.entity.OrderDetail;
import org.clothify.entity.OrderDetailKey;
import org.clothify.entity.OrderEntity;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Order;
import org.clothify.repository.OrderDetailRepository;
import org.clothify.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final ModelMapper mapper;
    final OrderRepository repository;
    final OrderDetail orderDetail;
    final OrderDetailKey orderDetailKey;
    final OrderDetailRepository orderDetailRepository;

    @Override
    public OrderEntity createOrder(Order order) {
        try{
            OrderEntity orderEntity = repository.save(mapper.map(order, OrderEntity.class));
            return orderEntity;
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public Set<OrderDetail> saveOrderDetail(OrderEntity order, ProductEntity[] products) {
        try{
            HashSet<OrderDetail> orderDetailsSet = new LinkedHashSet<>();
            orderDetailKey.setOrderId(order.getId());
            orderDetail.setOrder(order);

            for (ProductEntity product:products) {
                orderDetailKey.setItemId(product.getId());

                orderDetail.setId(orderDetailKey);
                orderDetail.setProduct(product);
                orderDetail.setQty(product.getCartQty());

                OrderDetail detailOfOrder = orderDetailRepository.save(orderDetail);
                orderDetailsSet.add(detailOfOrder);
            }

            return orderDetailsSet;
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public OrderEntity updateOrder(Set<OrderDetail> orderDetails, OrderEntity order) {
        order.setOrderDetails(orderDetails);
        OrderEntity savedOrderEntity = repository.save(order);
        return savedOrderEntity;
    }

    @Override
    public List<OrderEntity> getOrders() {
        return repository.findAll();
    }
}
