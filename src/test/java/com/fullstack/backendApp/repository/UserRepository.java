package com.fullstack.backendApp.repository;

import com.fullstack.backendApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Long> {
}
