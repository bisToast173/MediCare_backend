package com.example.medicare.controller;

import com.example.medicare.dto.SlotResponseDTO;
import com.example.medicare.service.AppointmentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorScheduleController {

    private final AppointmentService service;

    public DoctorScheduleController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/{doctorId}/slots/available")
    public List<SlotResponseDTO> getAvailableSlots(
            @PathVariable Integer doctorId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return service.getAvailableSlots(doctorId, date);
    }
}