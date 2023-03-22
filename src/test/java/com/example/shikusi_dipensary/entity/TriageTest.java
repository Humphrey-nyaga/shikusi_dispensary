package com.example.shikusi_dipensary.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TriageTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private Query query;

    @Mock
    private TypedQuery typedQuery;

    private Triage triage;

    @BeforeEach
    public void setUp() {
        triage = new Triage("Visit Reason", 70.0f, 180, 21.6f, 98, 36.6f, new Date(), 120, 80);
    }

    @Test
    @DisplayName("Test Triage save method")
    public void testSave() {
        when(entityManager.merge(any())).thenReturn(triage);

        Triage savedTriage = entityManager.merge(triage);

        Assertions.assertNotNull(savedTriage, "Saved Triage should not be null");
    }

    @Test
    @DisplayName("Test Triage findAll method")
    public void testFindAll() {
        List<Triage> triages = new ArrayList<>();
        triages.add(triage);

        when(entityManager.createQuery(eq("SELECT t FROM Triage t"), eq(Triage.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(triages);

        List<Triage> foundTriages = entityManager.createQuery("SELECT t FROM Triage t", Triage.class).getResultList();

        Assertions.assertEquals(1, foundTriages.size(), "Should have found one Triage");
        Assertions.assertEquals(triage, foundTriages.get(0), "Should have found the same Triage as created");
    }

    @Test
    @DisplayName("Test Triage findById method")
    public void testFindById() {
        when(entityManager.find(eq(Triage.class), any())).thenReturn(triage);

        Triage foundTriage = entityManager.find(Triage.class, triage.getId());

        Assertions.assertNotNull(foundTriage, "Found Triage should not be null");
        Assertions.assertEquals(triage, foundTriage, "Should have found the same Triage as created");
    }

    @Test
    @DisplayName("Test Triage delete method")
    public void testDelete() {
        when(entityManager.find(eq(Triage.class), any())).thenReturn(triage);
        when(entityManager.contains(triage)).thenReturn(true);

        entityManager.remove(triage);

        Assertions.assertFalse(entityManager.contains(triage), "Triage should have been removed");
    }

}
