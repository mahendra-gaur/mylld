package com.craft.service;

import com.craft.entity.LibraryEntity;
import com.craft.entity.ServiceEntity;
import com.craft.exception.ResourceNotFoundException;
import com.craft.repository.ServiceRepository;
import com.craft.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<ServiceEntity> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public ServiceEntity createService(ServiceEntity serviceEntity) {
        return serviceRepository.save(serviceEntity);
    }

    public ServiceEntity updateService(Long id, ServiceEntity serviceEntityDetails) {
        ServiceEntity serviceEntity = serviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ServiceEntity not found"));
        ServiceUtil.updateProperties(serviceEntityDetails, serviceEntity);
        return serviceRepository.save(serviceEntity);
    }

    public void deleteService(Long id) {
        ServiceEntity serviceEntity = serviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ServiceEntity not found"));
        serviceRepository.delete(serviceEntity);
    }

    public ServiceEntity addLibraryToService(Long serviceId, LibraryEntity libraryEntity) {
        Optional<ServiceEntity> service = getServiceById(serviceId);
        if (service.isPresent()) {
            ServiceEntity serviceEntityObject = service.get();
            serviceEntityObject.getLibraries().add(libraryEntity);
            return serviceRepository.save(serviceEntityObject);
        }
        return null;
    }
}
