package com.hashcorp.delivery.domain.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashcorp.delivery.domain.product.model.ProductRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long>, ProductRepository {

}
