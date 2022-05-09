package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.*;
import com.analogfilm.photolab.repository.OrderRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService service;

    @MockBean
    private OrderRepository ordRepo;

    @Test
    public void calculate() {
        Order testOrder = new Order();
        testOrder.setName_film(new Film("film", new Technology("tech", 5.5, 1), new Scan("scan", 1.1, 1.3), 3.1, ""));
        testOrder.setNeed_develop(true);
        testOrder.setNeed_scan(true);
        double result = service.calculate(testOrder);
        Assertions.assertEquals(9.9, result);
    }

    @Test
    public void saveOrder() {
        Order ord = new Order();
        ord.setId(1);
        List<Order> listorder = new ArrayList<>();
        listorder.add(ord);
        Mockito.doReturn(listorder)
                .when(ordRepo)
                .findById(1L);
    }

    @Test
    void findByUserName() {
        List<Order> listorder = new ArrayList<>();
        Order fst = new Order();
        fst.setUsername(new User("user3", "", ""));
        listorder.add(fst);
        listorder.add(fst);
        Mockito.doReturn(listorder).when(ordRepo).getOrdersByUserName("user3");
    }

    @Test
    void findByEmployeeNameInProgress() {
        List<Order> listorder = new ArrayList<>();
        Order fst = new Order();
        fst.setUsername(new User("pavel", "", ""));
        listorder.add(fst);
        Mockito.doReturn(listorder).when(ordRepo).getEmployeeOrderInProgress("pavel");
    }

    @Test
    void findByEmployeeNameArchive() {
        List<Order> listorder = new ArrayList<>();
        Order fst = new Order();
        fst.setUsername(new User("pavel", "", ""));
        listorder.add(fst);
        listorder.add(fst);
        Mockito.doReturn(listorder).when(ordRepo).getEmployeeOrderInProgress("pavel");
    }

    @Test
    void doneOrderById() {
        Order fst = new Order();
        fst.setId(1);
        fst.setIn_progress(false);
        service.doneOrderById(1L);
        Assert.assertEquals(fst.getId(), 1L);
    }
}
