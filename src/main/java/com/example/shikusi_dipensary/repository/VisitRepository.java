package com.example.shikusi_dipensary.repository;

import com.example.shikusi_dipensary.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

      /* The query includes the patient id in json response of each visit*/
       @Query("SELECT v.id as id, v.visitDate as visitDate, v.visitReason as visitReason, p.id as patientId FROM Visit v JOIN v.patient p WHERE p.id = :id")
        List<VisitProjection> findByPatient_Id(@Param("id") Long patientId);



}
