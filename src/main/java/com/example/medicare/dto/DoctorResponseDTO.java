package com.example.medicare.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResponseDTO {
    private Integer doctorId;
    private String doctorName;
    private short experienceYears;
    private String departmentName;

}
