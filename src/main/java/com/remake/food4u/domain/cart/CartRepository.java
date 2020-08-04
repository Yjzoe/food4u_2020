package com.remake.food4u.domain.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findById(String id);
}
