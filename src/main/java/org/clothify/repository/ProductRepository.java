package org.clothify.repository;

import org.clothify.entity.ImageEntity;
import org.clothify.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
