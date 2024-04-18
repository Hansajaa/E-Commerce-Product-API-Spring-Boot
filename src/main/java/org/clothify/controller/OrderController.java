package org.clothify.controller;

import lombok.RequiredArgsConstructor;
import org.clothify.Service.OrderService;
import org.clothify.entity.OrderEntity;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    final OrderService service;

    @PostMapping("/add")
    public ResponseEntity<OrderEntity> createOrder(@RequestPart Order order,
                                                   @RequestPart ProductEntity[] products){

        Set<ProductEntity> productEntities = getItemsSet(products);
        order.setItems(productEntities);
        OrderEntity entity = service.createOrder(order);
        return ResponseEntity.ok().body(entity);
    }


    private Set<ProductEntity> getItemsSet(ProductEntity[] products){
        Set<ProductEntity> items=new HashSet<>();

        for (ProductEntity entity:products) {
            items.add(entity);
        }

        return items;
    }
}
