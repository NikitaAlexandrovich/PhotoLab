package com.analogfilm.photolab.repository;

import com.analogfilm.photolab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
