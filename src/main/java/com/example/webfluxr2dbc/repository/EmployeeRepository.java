package com.example.webfluxr2dbc.repository;

import com.example.webfluxr2dbc.entity.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends R2dbcRepository<Employee, Integer> {
}
