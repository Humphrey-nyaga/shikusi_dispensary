package com.example.shikusi_dipensary.repository;

import com.example.shikusi_dipensary.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    void deleteEmployeeById(Long id);

    Optional <Patient>findPatientById(Long id);
}
