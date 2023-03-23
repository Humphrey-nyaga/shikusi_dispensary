package com.example.shikusi_dipensary.services;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.entity.Visit;
import com.example.shikusi_dipensary.exceptions.PatientNotFoundException;
import com.example.shikusi_dipensary.repository.PatientRepository;
import com.example.shikusi_dipensary.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public VisitService(PatientRepository patientRepository, VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
    }

    public Visit createVisit(Visit visit) {
        Patient patient = patientRepository.findById(visit.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient with id: " + visit.getPatientId() + " not found"));
        visit.setPatient(patient);
        return visitRepository.save(visit);
    }



}

