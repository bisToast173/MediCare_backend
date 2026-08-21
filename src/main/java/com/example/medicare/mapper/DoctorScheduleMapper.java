package com.example.medicare.mapper;

import com.example.medicare.dto.SlotResponseDTO;
import com.example.medicare.entity.DoctorSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface DoctorScheduleMapper {

    @Mapping(source = "id", target = "slotId")
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "doctor.user.fullName", target = "doctorName")
    @Mapping(source = "doctor.departments.id", target = "departmentId")
    @Mapping(source = "doctor.departments.name", target = "departmentName")
    @Mapping(
            source = "isAvailable",
            target = "status",
            qualifiedByName = "toStatus"
    )
    SlotResponseDTO toResponse(DoctorSchedule schedule);

    List<SlotResponseDTO> toResponseList(List<DoctorSchedule> schedules);

    @Named("toStatus")
    default String toStatus(boolean available) {
        return available ? "AVAILABLE" : "BOOKED";
    }
}