package com.example.shikusi_dipensary.controller;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PatientControllerTest {

    private PatientController patientController;

    @Mock
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        patientController = new PatientController(patientService);
    }

    @Test
    void testGetAllPatients() {
        // Create a mock patient list
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        List<Patient> mockPatientList = new ArrayList<>();
        mockPatientList.add(patient1);
        mockPatientList.add(patient2);

        // Stub the findAllPatients method of the patientService to return the mock patient list
        when(patientService.findAllPatients()).thenReturn(mockPatientList);

        // Call the getAllPatients method of the patientController
        ResponseEntity<List<Patient>> responseEntity = patientController.getAllPatients();

        // Verify that the response entity status is OK and the patient list is the same as the mock patient list
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockPatientList, responseEntity.getBody());
    }

    @Test
    void testGetPatient() {
        // Create a mock patient
        Patient mockPatient = new Patient();
        mockPatient.setId(1L);

        // Stub the findPatientById method of the patientService to return the mock patient
        when(patientService.findPatientById(1L)).thenReturn(mockPatient);

        // Call the getPatient method of the patientController with the mock patient id
        ResponseEntity<Patient> responseEntity = patientController.getPatient(1L);

        // Verify that the response entity status is OK and the patient is the same as the mock patient
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockPatient, responseEntity.getBody());
    }

    @Test
    void testAddPatient() {
        // Create a mock patient
        Patient mockPatient = new Patient();

        // Stub the addPatient method of the patientService to return the mock patient
        when(patientService.addPatient(mockPatient)).thenReturn(mockPatient);

        // Call the addPatient method of the patientController with the mock patient
        ResponseEntity<Patient> responseEntity = patientController.addPatient(mockPatient);

        // Verify that the response entity status is CREATED and the patient is the same as the mock patient
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockPatient, responseEntity.getBody());
    }

    @Test
    void testUpdatePatient() {
        // Create a mock patient
        Patient mockPatient = new Patient();
        mockPatient.setId(1L);

        // Stub the updatePatient method of the patientService to return the mock patient
        when(patientService.updatePatient(mockPatient)).thenReturn(mockPatient);

        // Call the updatePatient method of the patientController with the mock patient
        ResponseEntity<Patient> responseEntity = patientController.updatePatient(mockPatient);

        // Verify that the response entity status is OK and the patient is the same as the mock patient
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockPatient, responseEntity.getBody());
    }

    @Test
    void deletePatient_shouldReturnOkStatus() {
        Long patientId = 1L;
        doNothing().when(patientService).deletePatient(patientId);

        ResponseEntity<?> response = patientController.deletePatient(patientId);

        verify(patientService, times(1)).deletePatient(patientId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
