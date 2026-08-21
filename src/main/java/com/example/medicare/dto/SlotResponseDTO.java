package com.example.medicare.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class SlotResponseDTO {
    private Long slotId;
    private LocalDate scheduleDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer doctorId;
    private String doctorName;
    private Integer departmentId;
    private String departmentName;
    private String status;
}
