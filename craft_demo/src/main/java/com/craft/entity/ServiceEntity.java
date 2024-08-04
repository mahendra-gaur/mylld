package com.craft.entity;

import com.craft.model.ServiceType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "service")
public class ServiceEntity extends ResourceEntity {

    @ManyToMany
    private List<LibraryEntity> libraries;
    private ServiceType serviceType;
    private String deploymentPlatform;
    private String logUrl;

    //TODO: future enhancements
    //private String observability; // URL Grafana/AppDynamics
    //private String availability; // 99.99
}
