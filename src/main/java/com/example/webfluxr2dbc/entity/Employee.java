package com.example.webfluxr2dbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import reactor.core.publisher.Flux;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Employee {
    @Id
    @Column("emp_id")
    private Integer empId;
    private String name;
    private Integer age;
    private String email;
    @Transient
    private Set<Department> deps = new HashSet<>();

}
