package com.example.shikusi_dipensary.repository;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.entity.Triage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    void deletePatientById(Long id);

    Optional<Patient> findPatientById(Long id);
}
