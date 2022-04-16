package com.analogfilm.photolab.servise;

import com.analogfilm.photolab.models.User;
import com.analogfilm.photolab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByName(String id) {
        return userRepository.getUserByUsername(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        user.setPassword((new BCryptPasswordEncoder()).encode(user.getPassword()));
        if (user.getRole()==null) user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    public User saveAdmin(User user) {
        user.setPassword((new BCryptPasswordEncoder()).encode(user.getPassword()));
        if (user.getRole()==null) user.setRole("ROLE_ADMIN");
        return userRepository.save(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllEmployee() {
        return userRepository.getAllEmployee();
    }

}
