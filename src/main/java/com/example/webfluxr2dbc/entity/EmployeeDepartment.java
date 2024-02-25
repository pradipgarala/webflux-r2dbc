package com.example.webfluxr2dbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
public class EmployeeDepartment {
    @Id
    private Integer id;
    @Column("emp_id")
    private Integer empId;
    @Column("dep_id")
    private Integer depId;

}
