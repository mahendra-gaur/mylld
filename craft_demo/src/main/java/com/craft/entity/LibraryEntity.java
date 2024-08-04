package com.craft.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "library")
public class LibraryEntity extends ResourceEntity {

    private String version;

}
