package com.example.shikusi_dipensary.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class VisitTest {
    @Mock
    private Patient patient;

    @InjectMocks
    private Visit visit;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSetId() {
        Long expectedId = 1L;
        visit.setId(expectedId);
        Assertions.assertEquals(expectedId, visit.getId());
    }

    @Test
    void testGetSetVisitDate() {
        LocalDate expectedVisitDate = LocalDate.of(2022, 3, 10);
        visit.setVisitDate(expectedVisitDate);
        Assertions.assertEquals(expectedVisitDate, visit.getVisitDate());
    }

    @Test
    void testGetSetVisitReason() {
        String expectedVisitReason = "Headache";
        visit.setVisitReason(expectedVisitReason);
        Assertions.assertEquals(expectedVisitReason, visit.getVisitReason());
    }

    @Test
    void testGetSetPatient() {
        visit.setPatient(patient);
        Assertions.assertEquals(patient, visit.getPatient());
    }
}
