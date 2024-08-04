package com.craft.controller;

import com.craft.entity.LibraryEntity;
import com.craft.entity.ServiceEntity;
import com.craft.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntity> getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ServiceEntity createService(@RequestBody ServiceEntity serviceEntity) {
        return serviceService.createService(serviceEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> updateService(@PathVariable Long id, @RequestBody ServiceEntity serviceEntityDetails) {
        return ResponseEntity.ok(serviceService.updateService(id, serviceEntityDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/libraries")
    public ServiceEntity addLibraryToService(@PathVariable Long id, @RequestBody LibraryEntity libraryEntity) {
        return serviceService.addLibraryToService(id, libraryEntity);
    }
}
