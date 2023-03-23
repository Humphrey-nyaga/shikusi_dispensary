package com.example.shikusi_dipensary.repository;

import com.example.shikusi_dipensary.entity.Triage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TriageRepository extends JpaRepository<Triage, Long> {

    @Query("SELECT t FROM Triage t JOIN t.visit v JOIN v.patient p WHERE p.id = :patientId")
    Optional<Triage> findByPatientId(@Param("patientId") Long patientId);

    @Query("SELECT t FROM Triage t JOIN t.visit v WHERE v.id =:id ")
    Optional<Triage> findByVisitId(@Param("id") Long visitId);
}
