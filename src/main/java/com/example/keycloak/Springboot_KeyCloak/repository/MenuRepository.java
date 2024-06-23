package com.example.keycloak.Springboot_KeyCloak.repository;

import com.example.keycloak.Springboot_KeyCloak.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuRepository  extends JpaRepository<Menu, Long>{

	Menu findByRestaurantId(Long restaurantId);
}
