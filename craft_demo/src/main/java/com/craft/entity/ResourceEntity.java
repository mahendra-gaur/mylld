package com.craft.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private String codeRepository;
    private String lineOfBusiness;
}
