package org.clothify.repository;

import org.clothify.entity.OrderDetail;
import org.clothify.entity.OrderDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailKey> {
}
