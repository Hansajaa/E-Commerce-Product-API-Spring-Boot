package org.clothify.Service.impl;

import lombok.RequiredArgsConstructor;
import org.clothify.Service.OrderService;
import org.clothify.entity.OrderEntity;
import org.clothify.model.Order;
import org.clothify.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final ModelMapper mapper;
    final OrderRepository repository;
    @Override
    public OrderEntity createOrder(Order order) {
        OrderEntity orderEntity = repository.save(mapper.map(order, OrderEntity.class));
        return orderEntity;
    }
}
