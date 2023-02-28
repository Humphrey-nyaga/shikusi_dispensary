package com.example.shikusi_dipensary.repository;

import com.example.shikusi_dipensary.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    @Query("SELECT v FROM Visit v  inner join Patient p ON v.patient.id = p.id\s" +
           "WHERE v.id = :id")

    List<Visit> findByPatientId(@Param("id") Long patientId);
}
