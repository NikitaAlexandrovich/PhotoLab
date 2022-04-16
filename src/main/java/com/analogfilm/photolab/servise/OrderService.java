package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Order;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.repository.OrderRepository;
import com.analogfilm.photolab.repository.ScanRepository;
import com.analogfilm.photolab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.getAllOrders();
    }
    public List<Order> findByUserName(User name) {
        return orderRepository.getOrdersByUserName(name.getUsername());
    }

    public List<Order> findByEmployeeNameInProgress(String employeeName) { return orderRepository.getEmployeeOrderInProgress(employeeName); }
    public List<Order> findByEmployeeNameArchive(String employeeName) { return orderRepository.getEmployeeOrderArchive(employeeName); }


    public Order saveOrder(Order order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        order.setUsername(userRepository.getUserByUsername(currentPrincipalName));
        order.setIn_progress(true);
        double cost = order.getName_film().getFilm_prise();
        if(order.isNeed_develop()) {
            cost = cost + order.getName_film().getTech_name().getPrice();
        }
        if(order.isNeed_scan()) {
            cost = cost + order.getName_film().getScan_machine().getPrise();
        }
        order.setOrder_cost(cost);
        orderRepository.saveOrder(order.getUsername().getUsername(), order.getEmployee_name().getUsername(), order.getName_film().getName_film(), order.isIn_progress(), order.isNeed_develop(), order.isNeed_scan(), order.getOrder_cost());
        return order;
    }

    public void doneOrderById(Long id) {
        orderRepository.doneOrderById(id);
    }

}
