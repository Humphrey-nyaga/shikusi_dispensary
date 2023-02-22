package com.example.shikusi_dipensary.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "visit")
public class Visit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate visitDate;
    private String visitReason;


    public Long getId() {
        return id;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public Visit(){}

    public Visit(LocalDate visitDate, String visitReason){
        this.visitDate = visitDate;
        this.visitReason = visitReason;
    }

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patient patient;

    public void setPatient(Patient patient) {
    }
}
