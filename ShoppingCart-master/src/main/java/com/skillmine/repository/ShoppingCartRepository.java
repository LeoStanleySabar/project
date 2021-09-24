package com.skillmine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillmine.domain.ShoppingCart;

import java.util.List;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findByStatus(String status);
}
