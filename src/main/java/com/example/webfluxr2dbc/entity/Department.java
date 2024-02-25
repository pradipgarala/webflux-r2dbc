package com.example.webfluxr2dbc.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
public class Department {
    @Id
    @Column("dep_id")
    private Integer depId;
    private String name;
    private String description;
}
