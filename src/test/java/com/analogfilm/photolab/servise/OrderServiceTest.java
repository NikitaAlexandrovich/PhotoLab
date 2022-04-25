package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

// https://www.youtube.com/watch?v=QrSR1fm9JwA&t=518s

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    @MockBean
    private OrderService service;

    @Test
    public void testDoneOrder() {
        service.findAll();

    }

    @Test
    public void testCreateOrder() {
        Order first = new Order(1, new User("user1", "ppp", "role"), new User("employee", "ppp", "empl"), new Film("namefilm", new Technology("tech", 12.5, 3), new Scan("scan", 23.0, 22.0), 34, "120"), true, true, true, 68.5);
        Order saved = service.saveOrder(first);
        assertEquals(first, saved);
    }

    @Test
    public void tests() {
        assertEquals(1, 1);
    }

    @Test
    void findAll() {
    }

    @Test
    void findByUserName() {
    }

    @Test
    void findByEmployeeNameInProgress() {
    }

    @Test
    void findByEmployeeNameArchive() {
    }

    @Test
    void saveOrder() {
    }

    @Test
    void doneOrderById() {
    }
}
