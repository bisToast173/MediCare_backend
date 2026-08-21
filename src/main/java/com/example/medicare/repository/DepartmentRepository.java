package com.example.medicare.repository;

import com.example.medicare.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Departments, Integer> {
}