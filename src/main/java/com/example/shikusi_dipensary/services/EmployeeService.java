package com.example.shikusi_dipensary.services;

import com.example.shikusi_dipensary.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public EmployeeService(EmployeeRepository employeeRepository ,EmployeeService employeeService){
       this.employeeRepository = employeeRepository;
       this.employeeService = employeeService;
    }
}
