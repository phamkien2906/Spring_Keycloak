package com.example.keycloak.Springboot_KeyCloak.repository;

import com.example.keycloak.Springboot_KeyCloak.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
}
