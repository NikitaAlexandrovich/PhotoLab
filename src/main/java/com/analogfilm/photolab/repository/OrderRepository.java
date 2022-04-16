package com.analogfilm.photolab.repository;

import com.analogfilm.photolab.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    @Query(value = "SELECT * FROM FilmLab.`Order`", nativeQuery = true)
    List<Order> getAllOrders();
    @Query(value = "SELECT * FROM FilmLab.`Order` WHERE username = ?1", nativeQuery = true)
    List<Order> getOrdersByUserName(String name);

    @Modifying
    @Query(value = "insert into FilmLab.`Order` (username, employee_name, name_film, in_progress, need_develop, need_scan, order_cost) values (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    @Transactional
    void saveOrder(String usrname, String emplname, String nameFil, boolean prog, boolean dev, boolean scan, double cost);

    @Query(value = "SELECT t.* FROM FilmLab.`Order` t WHERE employee_name = ?1 and in_progress = 1", nativeQuery = true)
    List<Order> getEmployeeOrderInProgress(String empName);

    @Query(value = "SELECT t.* FROM FilmLab.`Order` t WHERE employee_name = ?1 and in_progress = 0", nativeQuery = true)
    List<Order> getEmployeeOrderArchive(String empName);

    @Modifying
    @Query(value = "UPDATE FilmLab.`Order` t SET t.in_progress = 0 WHERE t.id = ?1", nativeQuery = true)
    @Transactional
    void doneOrderById(Long id);
}
