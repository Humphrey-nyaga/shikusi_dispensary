package com.example.shikusi_dipensary.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {
    @Id @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String gender;
    private String maritalStatus;
    @Column(unique=true)
    private String nationalID;
    @Column(unique = true)
    private String email;
    private String country;
    private String city;
    private String address;
    private String phoneNumber;

    public Patient(){}

    public Patient(String name, String gender, String maritalStatus, String nationalID, String email, String country, String city, String address, String phoneNumber)
    {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.nationalID = nationalID;
        this.country = country;
        this.city = city;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setId(Long id) {
        this.id = id;
    }



    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public long getId() {
        return id;
    }

    public String getEmail(){
        return email;
    }
}
