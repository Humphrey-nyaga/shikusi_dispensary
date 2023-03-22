package com.example.shikusi_dipensary.repository;

import java.time.LocalDate;

public interface VisitProjection {
    Long getId();
    LocalDate getVisitDate();
    String getVisitReason();
     Long getPatientId();
}
