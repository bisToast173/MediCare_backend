package com.example.medicare.repository;

import com.example.medicare.entity.DoctorSchedule;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DoctorScheduleRepository
        extends JpaRepository<DoctorSchedule, Long> {

    @EntityGraph(attributePaths = {
            "doctor",
            "doctor.user",
            "doctor.departments"
    })
    List<DoctorSchedule>
    findByDoctor_IdAndScheduleDateAndIsAvailableTrueOrderByStartTimeAsc(
            Integer doctorId,
            LocalDate scheduleDate
    );

    @Override
    @EntityGraph(attributePaths = {
            "doctor",
            "doctor.user",
            "doctor.departments"
    })
    Optional<DoctorSchedule> findById(Long id);
}