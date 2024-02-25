package com.example.webfluxr2dbc.repository;

import com.example.webfluxr2dbc.entity.Department;
import com.example.webfluxr2dbc.entity.EmployeeDepartment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeDepartmentRepository extends R2dbcRepository<EmployeeDepartment, Integer> {
    Flux<EmployeeDepartment> findByEmpId(Integer empId);
}
