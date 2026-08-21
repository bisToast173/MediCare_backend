package com.example.medicare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
public class Doctors {
    @Id
    @Column(name = "doctor_id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "doctor_id")
    private Users user;

    @Column(name = "license_number", nullable = false)
    private String licenseNumber;

    @Column(name = "experience_years", nullable = false)
    private short experienceYears;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Departments departments;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;
}
