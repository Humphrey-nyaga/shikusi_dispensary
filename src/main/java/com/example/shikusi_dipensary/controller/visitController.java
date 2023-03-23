package com.example.shikusi_dipensary.controller;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.entity.Visit;
import com.example.shikusi_dipensary.repository.VisitProjection;
import com.example.shikusi_dipensary.repository.VisitRepository;
import com.example.shikusi_dipensary.services.PatientService;
import com.example.shikusi_dipensary.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/visit/")
public class visitController {
    private VisitRepository visitRepository;
    private VisitService visitService;
    private PatientService patientService;

    public visitController(@Autowired VisitRepository visitRepository , @Autowired VisitService visitService, @Autowired PatientService patientService){
        this.visitRepository = visitRepository;
        this.visitService = visitService;
        this.patientService = patientService;
    }

    @GetMapping("patient/{patientID}/")
    public Optional<VisitProjection> getVisitsForPatient(@PathVariable Long patientID){
        return visitRepository.findByPatient_Id(patientID);
    }


    /* Add patient visits */
    @PostMapping("patient/{patientID}/")
    public ResponseEntity<Map<String, Object>> createVisit(@PathVariable("patientID") Long patientID, @RequestBody Visit visit) {
        Patient patient = patientService.findPatientById(patientID);
        visit.setPatient(patient);
        LocalDate currentDate = LocalDate.now();
        visit.setVisitDate(currentDate);
        visitService.createVisit(visit);

        /*Return only specific data of the visit.
        * Without the map, successful creation of a visit response returns
        * a JSON with a patient bio data as well  which is not favourable*/
        Map<String, Object> response = new HashMap<>();
        response.put("id", visit.getId());
        response.put("visitDate", visit.getVisitDate());
        response.put("visitReason", visit.getVisitReason());
        response.put("patient_id", visit.getPatient().getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
