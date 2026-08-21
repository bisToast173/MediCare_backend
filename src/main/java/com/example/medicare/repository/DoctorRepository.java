package com.example.medicare.repository;

import com.example.medicare.entity.Doctors;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctors, Integer> {

    @EntityGraph(attributePaths = {"user", "departments"})
    List<Doctors> findByDepartments_IdOrderByUser_FullNameAsc (Integer departmentId);

}