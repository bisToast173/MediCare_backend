package com.example.medicare.service;

import com.example.medicare.dto.DepartmentResponseDTO;
import com.example.medicare.dto.DoctorResponseDTO;
import com.example.medicare.dto.SlotResponseDTO;
import com.example.medicare.entity.DoctorSchedule;
import com.example.medicare.mapper.DepartmentMapper;
import com.example.medicare.mapper.DoctorMapper;
import com.example.medicare.mapper.DoctorScheduleMapper;
import com.example.medicare.repository.DepartmentRepository;
import com.example.medicare.repository.DoctorRepository;
import com.example.medicare.repository.DoctorScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final DoctorScheduleRepository scheduleRepository;
    private final DepartmentMapper departmentMapper;
    private final DoctorMapper doctorMapper;
    private final DoctorScheduleMapper scheduleMapper;

    public AppointmentService( DepartmentRepository departmentRepository,
                               DoctorRepository doctorRepository,
                               DoctorScheduleRepository scheduleRepository,
                               DepartmentMapper departmentMapper,
                               DoctorMapper doctorMapper,
                               DoctorScheduleMapper scheduleMapper){

        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
        this.scheduleRepository = scheduleRepository;
        this.departmentMapper = departmentMapper;
        this.doctorMapper = doctorMapper;
        this.scheduleMapper = scheduleMapper;
    }

    public List<DepartmentResponseDTO> getDepartment(){
        return departmentMapper.toResponseList(departmentRepository.findAll());
    }

    public List<DoctorResponseDTO> getDoctorsByDepartment(Integer departmentId){
        if(!departmentRepository.existsById(departmentId)){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND,
                    "Không tìm thấy chuyên khoa: " + departmentId);
        }

        return doctorMapper.toResponseList(doctorRepository.findByDepartments_IdOrderByUser_FullNameAsc(departmentId));
    }

    public List<SlotResponseDTO> getAvailableSlots(Integer doctorId, LocalDate date){
        if(!doctorRepository.existsById(doctorId)){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND,
                    "Không tìm bác sĩ: " + doctorId);
        }

        if(date.isBefore(LocalDate.now())){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST,
                    "Ngày khám không được nằm trong quá khứ");
        }

        return scheduleMapper.toResponseList(scheduleRepository.findByDoctor_IdAndScheduleDateAndIsAvailableTrueOrderByStartTimeAsc(doctorId, date));
    }

    public SlotResponseDTO getSlot(Long slotId){
        DoctorSchedule schedule = scheduleRepository.findById(slotId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Không tìm thấy slot: " + slotId
                ));

        return scheduleMapper.toResponse(schedule);
    }


}
