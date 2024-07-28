package org.clothify.repository;

import org.clothify.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findAllByCategory(String category);

    @Query(value = "SELECT productID FROM Item ORDER BY id DESC LIMIT 1")
    String findLastId();
}
