package com.example.webfluxr2dbc.service;

import com.example.webfluxr2dbc.dto.DepartmentDto;
import com.example.webfluxr2dbc.entity.Department;
import com.example.webfluxr2dbc.exception.ResourceNotFoundException;
import com.example.webfluxr2dbc.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private static final String DEPARTMENT_NOT_FOUND = "Department not found";

    private final DepartmentRepository repository;
    private final ModelMapper modelMapper;


    public Flux<Department> findAll() {
        return repository.findAll();
    }

    public Mono<Department> findById(Integer depId) {
        return repository.findById(depId);
    }

    public Mono<Department> save(DepartmentDto dto) {
        Department entity = modelMapper.map(dto, Department.class);
        return repository.save(entity);
    }

    public Mono<Department> update(Integer depId, DepartmentDto dto) throws ExecutionException, InterruptedException {
        Department department = findOrThrowException(depId);

        modelMapper.map(dto, department);

        return repository.save(department);

    }

    private Department findOrThrowException(Integer depId) throws InterruptedException, ExecutionException {
        return Optional.ofNullable(repository.findById(depId)
                        .toFuture()
                        .get())
                .orElseThrow(() -> new ResourceNotFoundException(DEPARTMENT_NOT_FOUND));
    }


}
