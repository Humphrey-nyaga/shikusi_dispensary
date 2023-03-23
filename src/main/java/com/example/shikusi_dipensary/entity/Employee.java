package com.example.shikusi_dipensary.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;


@Entity
@Table(name = "employee")
public class Employee {

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
    @Column(name="employeeId", nullable=false)
    private UUID employeeId;

    public Employee(String firstname, String middlename, String lastname, String email, String dob, String password) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.password = password;
    }

    @Column(nullable = false)
    private String firstname;
    private String middlename;
    @Column(nullable = false)
    private String lastname;
    private String email;
    private String dob;
    private String password;

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public void setMiddleName(String middlename) {
        this.middlename = middlename;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
