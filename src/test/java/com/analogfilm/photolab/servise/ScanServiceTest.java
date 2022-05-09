package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.Film;
import com.analogfilm.photolab.models.Scan;
import com.analogfilm.photolab.repository.ScanRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
class ScanServiceTest {

    @MockBean
    private ScanRepository scanRepo;

    @Test
    void findAll() {
        ArrayList<Scan> lst = new ArrayList<>();
        lst.add(new Scan());
        Mockito.doReturn(lst)
                .when(scanRepo)
                .findAll();
    }

    @Test
    void deleteScan() {
        Mockito.doNothing().when(scanRepo).deleteById("testedScanName");
    }

    @Test
    void findByName() {
        Mockito.doReturn(new Film())
                .when(scanRepo)
                .getById("name");
    }

    @Test
    void saveScan() {
        Mockito.doReturn(new Film())
                .when(scanRepo)
                .save(new Scan());
    }
}