package com.example.shikusi_dipensary.services;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.entity.Visit;
import com.example.shikusi_dipensary.exceptions.PatientNotFoundException;
import com.example.shikusi_dipensary.repository.PatientRepository;
import com.example.shikusi_dipensary.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class VisitService {
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public VisitService(PatientRepository patientRepository, VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
    }

    public ResponseEntity<Object> addVisit(Long patientId, Visit visit) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient with id:  " + patientId + " not found"));

        //TODO: Ensure the patient ID is added into Db when other visit details are added
        visit.setPatient(patient);
        visitRepository.save(visit);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(visit.getId()).toUri();
        return ResponseEntity.created(location).build();
    }



    }

