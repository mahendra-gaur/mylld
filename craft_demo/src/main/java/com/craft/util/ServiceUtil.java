package com.craft.util;

import com.craft.entity.ServiceEntity;

public class ServiceUtil {
    public static void updateProperties(ServiceEntity serviceEntityDetails, ServiceEntity serviceEntity) {
        serviceEntity.setName(serviceEntityDetails.getName());
        serviceEntity.setDescription(serviceEntityDetails.getDescription());
        serviceEntity.setCodeRepository(serviceEntityDetails.getCodeRepository());
        serviceEntity.setLineOfBusiness(serviceEntityDetails.getLineOfBusiness());

        serviceEntity.setServiceType(serviceEntityDetails.getServiceType());
        serviceEntity.setLibraries(serviceEntityDetails.getLibraries());
        serviceEntity.setDeploymentPlatform(serviceEntityDetails.getDeploymentPlatform());
        serviceEntity.setLogUrl(serviceEntityDetails.getLogUrl());
    }
}
