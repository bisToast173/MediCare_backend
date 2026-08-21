package com.example.medicare.mapper;

import com.example.medicare.dto.DoctorResponseDTO;
import com.example.medicare.entity.Doctors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DoctorMapper {

    @Mapping(source = "id", target = "doctorId")
    @Mapping(source = "user.fullName", target = "doctorName")
    @Mapping(source = "departments.name", target = "departmentName")
    DoctorResponseDTO toResponse(Doctors doctor);

    List<DoctorResponseDTO> toResponseList(List<Doctors> doctors);
}