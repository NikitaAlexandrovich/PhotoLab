package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Order;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.repository.OrderRepository;
import com.analogfilm.photolab.repository.ScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
//        List<Order> a = new ArrayList<>();
//        a.add(new Order(1, new User(), new User(), new Film(), true, true, false));
//        return a;
//        return orderRepository.findAll();
        return orderRepository.getAllOrders();
    }

}
