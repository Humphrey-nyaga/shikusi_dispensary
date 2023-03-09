package com.example.shikusi_dipensary.entity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.shikusi_dipensary.entity.Patient;
import com.example.shikusi_dipensary.entity.Visit;
import jakarta.persistence.OneToMany;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PatientTest {

    private Patient patient;

    @BeforeEach
    public void setup() {
        patient = new Patient("John Smith", "Male", "Single", "123456", "john.smith@example.com", "USA", "New York", "123 Main St", "555-1234");
    }

    @Test
    public void testGetName() {
        assertEquals("John Smith", patient.getName());
    }

    @Test
    public void testGetGender() {
        assertEquals("Male", patient.getGender());
    }

    @Test
    public void testGetMaritalStatus() {
        assertEquals("Single", patient.getMaritalStatus());
    }

    @Test
    public void testGetNationalID() {
        assertEquals("123456", patient.getNationalID());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.smith@example.com", patient.getEmail());
    }

    @Test
    public void testGetCountry() {
        assertEquals("USA", patient.getCountry());
    }

    @Test
    public void testGetCity() {
        assertEquals("New York", patient.getCity());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", patient.getAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("555-1234", patient.getPhoneNumber());
    }

    @Test
    public void testGetVisits() {
        // create a mock visit list
        Visit visit1 = mock(Visit.class);
        Visit visit2 = mock(Visit.class);
        List<Visit> mockVisitList = new ArrayList<>();
        mockVisitList.add(visit1);
        mockVisitList.add(visit2);

        // set the mock visit list on the patient object
        patient.setVisits(mockVisitList);

        // verify that the visit list returned by the patient object is the same as the mock visit list
        assertEquals(mockVisitList, patient.getVisits());
    }
}
