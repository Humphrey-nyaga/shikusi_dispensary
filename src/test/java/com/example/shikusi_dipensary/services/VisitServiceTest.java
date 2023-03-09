package com.example.shikusi_dipensary.services;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.entity.Visit;
import com.example.shikusi_dipensary.exceptions.PatientNotFoundException;
import com.example.shikusi_dipensary.repository.PatientRepository;
import com.example.shikusi_dipensary.repository.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VisitServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitService visitService;

    @Test
    public void testAddVisit() {
        // Create a mock patient
        Patient patient = new Patient("John Doe", "Male", "Single", "123456789", "john.doe@example.com", "USA", "New York", "123 Main St", "555-1234");
        patient.setId(1L);


        // Create a mock visit
        Visit visit = new Visit( LocalDate.now(), "Some notes");
        visit.setId(1L);
        // Set up mock patient repository to return the mock patient
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        // Set up mock visit repository to return the saved visit with an ID
        Visit savedVisit = new Visit( LocalDate.now(), "Some notes");
        when(visitRepository.save(any(Visit.class))).thenReturn(savedVisit);

        // Call the addVisit method
        Visit returnedVisit = visitService.addVisit(1L, visit);

        // Verify that the patient was retrieved from the repository
        verify(patientRepository, times(1)).findById(1L);

        // Verify that the visit was saved with the patient
        ArgumentCaptor<Visit> visitArgumentCaptor = ArgumentCaptor.forClass(Visit.class);
        verify(visitRepository, times(1)).save(visitArgumentCaptor.capture());
        Visit savedVisitArgument = visitArgumentCaptor.getValue();
        assertEquals(savedVisitArgument.getPatient(), patient);

        // Verify that the returned visit matches the saved visit
        assertEquals(returnedVisit, savedVisit);
    }

    @Test
    public void testAddVisitWithNonExistentPatient() {
        // Create a mock patient ID
        Long patientId = 1L;

        // Set up mock patient repository to return an empty optional
        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        // Create a mock visit
        Visit visit = new Visit( LocalDate.now(), "Some notes");

        // Call the addVisit method and verify that it throws a PatientNotFoundException
        assertThrows(PatientNotFoundException.class, () -> visitService.addVisit(patientId, visit));

        // Verify that the patient was retrieved from the repository
        verify(patientRepository, times(1)).findById(patientId);

        // Verify that the visit was not saved
        verify(visitRepository, never()).save(any(Visit.class));
    }
}
