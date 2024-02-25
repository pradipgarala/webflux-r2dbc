package com.example.webfluxr2dbc.controller;

import com.example.webfluxr2dbc.dto.EmployeeDto;
import com.example.webfluxr2dbc.entity.Employee;
import com.example.webfluxr2dbc.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    Flux<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{empId}")
    Mono<Employee> getById(@PathVariable Integer empId) throws ExecutionException, InterruptedException {
        return employeeService.findById(empId);
    }

    @PostMapping
    Mono<Employee> save(@RequestBody EmployeeDto dto) {
        return employeeService.save(dto);
    }

    @PatchMapping("/{empId}")
    Mono<Employee> update(@PathVariable Integer empId,
                            @Valid @RequestBody EmployeeDto dto) throws ExecutionException, InterruptedException {
        return employeeService.update(empId, dto);
    }

}
