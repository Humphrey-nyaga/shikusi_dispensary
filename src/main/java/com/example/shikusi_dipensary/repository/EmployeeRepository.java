package com.example.shikusi_dipensary.repository;

import com.example.shikusi_dipensary.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    @Override
    Optional<Employee> findById(UUID uuid);

    @Override
    List<Employee> findAll(Sort sort);

    void deleteEmployeeByEmployee_id(UUID uuid);

    @Override
    Page<Employee> findAll(Pageable pageable);
}

