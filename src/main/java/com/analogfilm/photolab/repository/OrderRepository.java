package com.analogfilm.photolab.repository;

import com.analogfilm.photolab.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    @Query(value = "SELECT * FROM FilmLab.`Order`", nativeQuery = true)
    List<Order> getAllOrders();
}
