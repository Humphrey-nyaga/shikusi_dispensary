package com.example.shikusi_dipensary.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "triage")
public class Triage implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "triageID", nullable = false)
    private UUID triageID;

    /*
     * Patient Vitals at triage
     * */
    @Column(unique=true)
    private int patientID;
    private String visitReason;
    private float weight;
    private int height;
    private float bodyMassIndex;
    private int oxygenSaturation;
    private float temperatureDegreeCelcius;
    private Date date;

    /*
     * sysBP - Systole blood pressure
     * diasBP - Diastole blood pressure
     * */
    private int sysBP;
    private int diasBP;

    @ManyToOne
    @JoinColumn(name = "visit_id", referencedColumnName = "id")
    private Visit visit;

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Triage(){}
    public Triage(String visitReason, float weight, int height, float bodyMassIndex,
                  int oxygenSaturation, float temperatureDegreeCelcius, Date date, int sysBP,int diasBP)
    {
        this.visitReason = visitReason;
        this.weight = weight;
        this.height = height;
        this.bodyMassIndex = bodyMassIndex;
        this.oxygenSaturation = oxygenSaturation;
        this.temperatureDegreeCelcius = temperatureDegreeCelcius;
        this.date = date;
        this.sysBP = sysBP;
        this.diasBP = diasBP;
    }

    /*Setters*/
    public void setVisitReason (String visitReason){
        this.visitReason = visitReason;
    }public void setWeight(float weight){
    this.weight = weight;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setBodyMassIndex(float bodyMassIndex){
        this.bodyMassIndex = bodyMassIndex;
    }
    public void setOxygenSaturation(int oxygenSaturation){
        this.oxygenSaturation = oxygenSaturation;
    }

    public void setTemperatureDegreeCelcius(float temperatureDegreeCelcius)
    {
        this.temperatureDegreeCelcius = temperatureDegreeCelcius;
    }

    public void setDiasBP(int diasBP) {
        this.diasBP = diasBP;
    }
    public void setSysBP(int sysBP)
    {
        this.sysBP = sysBP;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /*Getters*/

    public float getBodyMassIndex() {
        return bodyMassIndex;
    }

    public float getTemperatureDegreeCelcius() {
        return temperatureDegreeCelcius;
    }

    public float getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getDiasBP() {
        return diasBP;
    }

    public int getOxygenSaturation() {
        return oxygenSaturation;
    }

    public int getSysBP() {
        return sysBP;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public Date getDate() {
        return date;
    }
    public UUID getTriageID() {
        return triageID;
    }

    public void setTriageID(UUID triageID) {
        this.triageID = triageID;
    }

}
