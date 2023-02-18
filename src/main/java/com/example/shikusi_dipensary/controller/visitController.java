package com.example.shikusi_dipensary.controller;

import com.example.shikusi_dipensary.entity.Visit;
import com.example.shikusi_dipensary.repository.VisitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patient/{patientID}/allVisits")
public class visitController {
    private VisitRepository visitRepository;

    public visitController(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    @GetMapping
    public List<Visit> getVisitsForPatient(@PathVariable Long patientID){
        return visitRepository.findByPatientId(patientID);
    }
}
