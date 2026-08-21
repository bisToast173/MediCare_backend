package com.example.medicare.controller;

import com.example.medicare.dto.SlotResponseDTO;
import com.example.medicare.service.AppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/slot")
public class SlotController {
    private final AppointmentService service;

    public SlotController(AppointmentService service){
        this.service = service;
    }

    @GetMapping("/{slotId}")
    public SlotResponseDTO getSlot(@PathVariable Long slotId) {
        return service.getSlot(slotId);
    }

}
