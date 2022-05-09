package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.models.Technology;
import com.analogfilm.photolab.repository.ScanRepository;
import com.analogfilm.photolab.repository.TechnologyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
class TechnologyServiceTest {

    @MockBean
    private TechnologyRepository techRepo;

    @Test
    void findAll() {
        ArrayList<Technology> lst = new ArrayList<>();
        lst.add(new Technology());
        Mockito.doReturn(lst)
                .when(techRepo)
                .findAll();
    }

    @Test
    void deleteTech() {
        Mockito.doNothing().when(techRepo).deleteById("testedTechName");
    }

    @Test
    void findByName() {
        Mockito.doReturn(new Technology())
                .when(techRepo)
                .getById("name");
    }

    @Test
    void saveTech() {
        Mockito.doReturn(new Technology())
                .when(techRepo)
                .save(new Technology());
    }
}