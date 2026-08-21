package com.example.medicare.mapper;

import com.example.medicare.dto.DepartmentResponseDTO;
import com.example.medicare.entity.Departments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DepartmentMapper {

    @Mapping(source = "id", target = "departmentId")
    DepartmentResponseDTO toResponse(Departments department);

    List<DepartmentResponseDTO> toResponseList(List<Departments> departments);
}