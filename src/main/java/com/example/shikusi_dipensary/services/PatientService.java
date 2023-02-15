package com.example.shikusi_dipensary.services;

import com.example.shikusi_dipensary.exceptions.PatientNotFoundException;
import com.example.shikusi_dipensary.repository.PatientRepository;
import com.example.shikusi_dipensary.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findAllPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient findPatientById(Long id) {
        return patientRepository.findPatientById(id)
                .orElseThrow(()-> new PatientNotFoundException("Patient with id: " + " not found."));
    }
    public void deletePatient(Long id){
         patientRepository.deleteEmployeeById(id);
    }
}
