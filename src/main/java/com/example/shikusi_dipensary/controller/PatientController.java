package com.example.shikusi_dipensary.controller;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService)
    {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable("id")Long id){
        Patient patient = patientService.findPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        Patient updatedPatient = patientService.updatePatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id")Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
