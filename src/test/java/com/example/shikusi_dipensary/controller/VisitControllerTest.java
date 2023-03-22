package com.example.shikusi_dipensary.controller;

import com.example.shikusi_dipensary.entity.Visit;
import com.example.shikusi_dipensary.repository.VisitProjection;
import com.example.shikusi_dipensary.repository.VisitRepository;
import com.example.shikusi_dipensary.services.PatientService;
import com.example.shikusi_dipensary.services.VisitService;
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

public class VisitControllerTest {

    private visitController visitController;

    @Mock
    private VisitRepository visitRepository;

    @Mock
    private VisitService visitService;
     @Mock
     private PatientService patientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        visitController = new visitController(visitRepository, visitService, patientService);
    }

   /* @Test
    public void testGetVisitsForPatient() {
        Long patientID = 1L;
        List<Visit> visits = new ArrayList<>();
        visits.add(new Visit());
        visits.add(new Visit());
        when(visitRepository.findByPatient_Id(patientID)).thenReturn(visits);

        List<VisitProjection> result = visitController.getVisitsForPatient(patientID);

        assertEquals(2, result.size());
        verify(visitRepository, times(1)).findByPatientId(patientID);
    }
*/
   /* @Test
    void testAddVisit() {
        Long patientID = 1L;
        Visit visit = new Visit();
        when(visitService.addVisit(patientID, visit)).thenReturn(visit);

        ResponseEntity<Visit> responseEntity = visitController.addVisit(patientID, visit);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(visit, responseEntity.getBody());
    } */
}
