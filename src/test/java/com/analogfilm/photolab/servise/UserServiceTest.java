package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Technology;
import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.repository.TechnologyRepository;
import com.analogfilm.photolab.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @MockBean
    private UserRepository userRepo;

    @Test
    void findByName() {
        Mockito.doReturn(new User())
                .when(userRepo)
                .getById("name");
    }

    @Test
    void findAll() {
        ArrayList<User> lst = new ArrayList<>();
        lst.add(new User());
        Mockito.doReturn(lst)
                .when(userRepo)
                .findAll();
    }

    @Test
    void saveUser() {
        Mockito.doReturn(new User())
                .when(userRepo)
                .save(new User());
    }

    @Test
    void saveAdmin() {
        Mockito.doReturn(new User())
                .when(userRepo)
                .save(new User());
    }

    @Test
    void saveEmployee() {
        Mockito.doReturn(new User())
                .when(userRepo)
                .save(new User());
    }

    @Test
    void deleteById() {
        Mockito.doNothing().when(userRepo).deleteById("testedTechName");
    }

    @Test
    void getAllEmployee() {
        ArrayList<User> lst = new ArrayList<>();
        lst.add(new User());
        Mockito.doReturn(lst)
                .when(userRepo)
                .getAllEmployee();
    }

    @Test
    void getAllAdmins() {
        ArrayList<User> lst = new ArrayList<>();
        lst.add(new User());
        Mockito.doReturn(lst)
                .when(userRepo)
                .getAllAdmins();
    }

    @Test
    void getAllClient() {
        ArrayList<User> lst = new ArrayList<>();
        lst.add(new User());
        Mockito.doReturn(lst)
                .when(userRepo)
                .getAllClient();
    }
}