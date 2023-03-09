package com.example.shikusi_dipensary.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.entity.Visit;
import com.example.shikusi_dipensary.exceptions.PatientNotFoundException;
import com.example.shikusi_dipensary.repository.PatientRepository;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    private Patient patient;
    private Visit visit;

    @BeforeEach
    void setUp() {
        patient = new Patient();
        patient.setId(1L);
        patient.setName("John Doe");

        visit = new Visit();
        visit.setId(1L);
        visit.setPatient(patient);
    }

    @Test
    @DisplayName("Test findAllPatients")
    void testFindAllPatients() {
        List<Patient> patients = new ArrayList<>();
        patients.add(patient);

        when(patientRepository.findAll()).thenReturn(patients);

        List<Patient> result = patientService.findAllPatients();

        assertThat(result.size()).isEqualTo(patients.size());
        assertThat(result.get(0)).isEqualTo(patient);

        verify(patientRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test addPatient")
    void testAddPatient() {
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientService.addPatient(patient);

        assertThat(result).isEqualTo(patient);

        verify(patientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    @DisplayName("Test updatePatient")
    void testUpdatePatient() {
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientService.updatePatient(patient);

        assertThat(result).isEqualTo(patient);

        verify(patientRepository, times(1)).findById(patient.getId());
        verify(patientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    @DisplayName("Test updatePatient with non-existent patient")
    void testUpdatePatientWithNonExistentPatient() {
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> patientService.updatePatient(patient))
                .isInstanceOf(PatientNotFoundException.class)
                .hasMessage("Patient with id " + patient.getId() + " not found");

        verify(patientRepository, times(1)).findById(patient.getId());
    }

    @Test
    @DisplayName("Test deletePatient")
    void testDeletePatient() {
        patientService.deletePatient(patient.getId());

        verify(patientRepository, times(1)).deletePatientById(patient.getId());
    }

    @Test
    @DisplayName("Test findPatientById")
    void testFindPatientById() {
        when(patientRepository.findPatientById(patient.getId())).thenReturn(Optional.of(patient));

        Patient result = patientService.findPatientById(patient.getId());

        assertThat(result).isEqualTo(patient);

        verify(patientRepository, times(1)).findPatientById(patient.getId());
    }
}
