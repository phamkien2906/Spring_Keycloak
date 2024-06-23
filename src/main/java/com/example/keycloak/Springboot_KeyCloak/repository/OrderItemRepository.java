package com.example.keycloak.Springboot_KeyCloak.repository;

import java.util.List;

import com.example.keycloak.Springboot_KeyCloak.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	List<OrderItem> findByOrderId(Long id);

}
