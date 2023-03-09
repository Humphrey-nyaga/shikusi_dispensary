package com.example.shikusi_dipensary.controller;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.entity.Visit;
import com.example.shikusi_dipensary.repository.VisitRepository;
import com.example.shikusi_dipensary.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class visitController {
    private VisitRepository visitRepository;
    private VisitService visitService;

    public visitController(@Autowired VisitRepository visitRepository , @Autowired VisitService visitService){
        this.visitRepository = visitRepository;
        this.visitService = visitService;
    }

    @GetMapping("/{patientID}/allVisits")
    public List<Visit> getVisitsForPatient(@PathVariable Long patientID){
        return visitRepository.findByPatientId(patientID);
    }


    @PostMapping("{patientID}/addVisit")
    public ResponseEntity<Visit> addVisit(@PathVariable("patientID")Long patientID, @RequestBody Visit visit){
        visitService.addVisit(patientID, visit);
        return new ResponseEntity<>(visit, HttpStatus.CREATED);
    }


}
