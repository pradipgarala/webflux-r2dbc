package com.example.webfluxr2dbc.repository;

import com.example.webfluxr2dbc.entity.Department;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends R2dbcRepository<Department, Integer> {
}
