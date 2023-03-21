package com.example.shikusi_dipensary.repository;

import com.example.shikusi_dipensary.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
        /*@Query("SELECT v.id as id, v.visitDate as visitDate, v.visitReason as visitReason FROM Visit v WHERE v.patient.id = :id")
        List<VisitProjection> findByPatient_Id(@Param("id") Long patientId); */
                @Query("SELECT v.id as id, v.visitDate as visitDate, v.visitReason as visitReason, v.patient.id as patientId FROM Visit v WHERE v.patient.id = :id")
                List<VisitResponse> findByPatient_Id(@Param("id") Long patientId);


}
