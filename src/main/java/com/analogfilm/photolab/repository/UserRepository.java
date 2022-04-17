package com.analogfilm.photolab.repository;

import com.analogfilm.photolab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u Where u.username = :username")
    User getUserByUsername(@Param("username") String username);

    @Query(value = "SELECT t.* FROM FilmLab.User t WHERE role like 'ROLE_EMPLOYEE'", nativeQuery = true)
    List<User> getAllEmployee();

    @Query(value = "SELECT t.* FROM FilmLab.User t WHERE role like 'ROLE_ADMIN'", nativeQuery = true)
    List<User> getAllAdmins();

    @Query(value = "SELECT t.* FROM FilmLab.User t WHERE role like 'ROLE_USER'", nativeQuery = true)
    List<User> getAllClient();
}
