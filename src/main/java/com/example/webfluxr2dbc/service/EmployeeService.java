package com.example.webfluxr2dbc.service;

import com.example.webfluxr2dbc.dto.EmployeeDto;
import com.example.webfluxr2dbc.entity.Employee;
import com.example.webfluxr2dbc.exception.ResourceNotFoundException;
import com.example.webfluxr2dbc.repository.DepartmentRepository;
import com.example.webfluxr2dbc.repository.EmployeeDepartmentRepository;
import com.example.webfluxr2dbc.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private static final String EMPLOYEE_NOT_FOUND = "Employee not found";

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeDepartmentRepository employeeDepartmentRepository;
    private final ModelMapper modelMapper;


    public Flux<Employee> findAll() {
        return employeeRepository.findAll()
                .map(e -> {
                    employeeDepartmentRepository.findAll()
                            .filter(ed -> Objects.equals(ed.getEmpId(), e.getEmpId()))
                            .flatMap(ed -> departmentRepository.findById(ed.getDepId()))
                            .subscribe(d -> e.getDeps().add(d));
                    return e;
                });
    }

    public Mono<Employee> findById(Integer empId) throws ExecutionException, InterruptedException {
        Employee employee = findOrThrowException(empId);

        employeeDepartmentRepository.findByEmpId(employee.getEmpId())
                .flatMap(ed -> departmentRepository.findById(ed.getDepId()))
                .subscribe(d -> employee.getDeps().add(d));

        return Mono.just(employee);
    }

    public Mono<Employee> save(EmployeeDto dto) {
        Employee entity = modelMapper.map(dto, Employee.class);
        return employeeRepository.save(entity);
    }

    public Mono<Employee> update(Integer empId, EmployeeDto dto) throws ExecutionException, InterruptedException {
        Employee employee = findOrThrowException(empId);

        modelMapper.map(dto, employee);

        return employeeRepository.save(employee);
    }

    private Employee findOrThrowException(Integer empId) throws InterruptedException, ExecutionException {
        return Optional.ofNullable(employeeRepository.findById(empId)
                        .toFuture()
                        .get())
                .orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE_NOT_FOUND));
    }

}
