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
    public void testSetName() {
        patient.setName("Jane Doe");
        assertEquals("Jane Doe", patient.getName());
    }

    @Test
    public void testGetGender() {
        assertEquals("Male", patient.getGender());
    }

    @Test
    public void testSetGender() {
        patient.setGender("Female");
        assertEquals("Female", patient.getGender());
    }

    @Test
    public void testGetMaritalStatus() {
        assertEquals("Single", patient.getMaritalStatus());
    }

    @Test
    public void testSetMaritalStatus() {
        patient.setMaritalStatus("Married");
        assertEquals("Married", patient.getMaritalStatus());
    }

    @Test
    public void testGetNationalID() {
        assertEquals("123456", patient.getNationalID());
    }

    @Test
    public void testSetNationalID() {
        patient.setNationalID("654321");
        assertEquals("654321", patient.getNationalID());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.smith@example.com", patient.getEmail());
    }

    @Test
    public void testSetEmail() {
        patient.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", patient.getEmail());
    }

    @Test
    public void testGetCountry() {
        assertEquals("USA", patient.getCountry());
    }

    @Test
    public void testSetCountry() {
        patient.setCountry("Canada");
        assertEquals("Canada", patient.getCountry());
    }

    @Test
    public void testGetCity() {
        assertEquals("New York", patient.getCity());
    }

    @Test
    public void testSetCity() {
        patient.setCity("Toronto");
        assertEquals("Toronto", patient.getCity());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", patient.getAddress());
    }

    @Test
    public void testSetAddress() {
        patient.setAddress("456 Oak St");
        assertEquals("456 Oak St", patient.getAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("555-1234", patient.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        patient.setPhoneNumber("555-5678");
        assertEquals("555-5678", patient.getPhoneNumber());
    }
    @Test
    public void testSetVisits() {
        // create a mock visit list
        Visit visit1 = mock(Visit.class);
        Visit visit2 = mock(Visit.class);
        List<Visit> mockVisitList = new ArrayList<>();
        mockVisitList.add(visit1);
        mockVisitList.add(visit2);

        // set the mock visit list on the patient object
        patient.setVisits(mockVisitList);

        // verify that the visit list set on the patient object is the same as the mock visit list
        assertEquals(mockVisitList, patient.getVisits());
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
