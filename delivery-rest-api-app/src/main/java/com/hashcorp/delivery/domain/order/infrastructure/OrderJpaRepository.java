package com.hashcorp.delivery.domain.order.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hashcorp.delivery.domain.order.model.OrderRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long>, OrderRepository {

	@Query(value = "select * from \"order\"", nativeQuery = true)
	@Override
	List<OrderEntity> findAll();
}
