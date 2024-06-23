package com.example.keycloak.Springboot_KeyCloak.repository;

import java.util.List;

import com.example.keycloak.Springboot_KeyCloak.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{

	List<MenuItem> findAllByMenuId(Long id);

}
