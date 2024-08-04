package org.clothify.controller;

import lombok.RequiredArgsConstructor;
import org.clothify.Service.OrderService;
import org.clothify.entity.OrderDetail;
import org.clothify.entity.OrderEntity;
import org.clothify.entity.ProductEntity;
import org.clothify.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
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
            try{
                OrderEntity entity = service.createOrder(order);
                saveOrderDetail(entity,products);
                return ResponseEntity.ok().body(entity);
            }catch(Exception e){
                return ResponseEntity.badRequest().body(null);
            }

    }


    private Set<OrderDetail> saveOrderDetail(OrderEntity order, ProductEntity[] products){
        try{
            Set<OrderDetail> orderDetails = service.saveOrderDetail(order, products);
            return orderDetails;
        }catch (Exception e){
            throw e;
        }

    }

    @GetMapping
    public List<OrderEntity> getAllOrders(){
        return service.getOrders();
    }
}
