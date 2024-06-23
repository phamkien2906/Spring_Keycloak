package com.example.keycloak.Springboot_KeyCloak.repository;

import java.util.List;

import com.example.keycloak.Springboot_KeyCloak.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByRestaurantId(Long restaurantId);

}
