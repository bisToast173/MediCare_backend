package com.example.medicare.controller;

import com.example.medicare.dto.DepartmentResponseDTO;
import com.example.medicare.dto.DoctorResponseDTO;
import com.example.medicare.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final AppointmentService service;

    public DepartmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<DepartmentResponseDTO> getDepartments() {
        return service.getDepartment();
    }

    @GetMapping("/{departmentId}/doctors")
    public List<DoctorResponseDTO> getDoctorsByDepartment(
            @PathVariable Integer departmentId
    ) {
        return service.getDoctorsByDepartment(departmentId);
    }
}