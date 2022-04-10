package com.analogfilm.photolab.repositoty;

import com.analogfilm.photolab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
