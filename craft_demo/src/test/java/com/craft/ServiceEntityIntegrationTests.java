package com.craft;

import com.craft.entity.LibraryEntity;
import com.craft.entity.ServiceEntity;
import com.craft.model.ServiceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ServiceEntityIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateService_success() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("GithubUploadTest ServiceEntity");
        serviceEntity.setServiceType(ServiceType.P1);
        serviceEntity.setDeploymentPlatform("AWS");
        serviceEntity.setLogUrl("http://log.url");

        ResponseEntity<ServiceEntity> response = restTemplate.postForEntity("/api/services", serviceEntity, ServiceEntity.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("GithubUploadTest ServiceEntity");
    }

    @Test
    public void testCreateService_missingName() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setServiceType(ServiceType.P2);
        serviceEntity.setDeploymentPlatform("Azure");

        ResponseEntity<String> response = restTemplate.postForEntity("/api/services", serviceEntity, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).contains("name must not be null");
    }

    @Test
    public void testGetServiceById_success() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("Get ServiceEntity GithubUploadTest");
        serviceEntity.setServiceType(ServiceType.P2);
        serviceEntity.setDeploymentPlatform("GCP");
        ResponseEntity<ServiceEntity> createResponse = restTemplate.postForEntity("/api/services", serviceEntity, ServiceEntity.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        ResponseEntity<ServiceEntity> response = restTemplate.getForEntity("/api/services/{id}", ServiceEntity.class, createResponse.getBody().getId());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Get ServiceEntity GithubUploadTest");
    }

    @Test
    public void testGetServiceById_notFound() {
        ResponseEntity<ServiceEntity> response = restTemplate.getForEntity("/api/services/{id}", ServiceEntity.class, 999L);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testUpdateService_success() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("Update GithubUploadTest ServiceEntity");
        serviceEntity.setServiceType(ServiceType.P1);
        serviceEntity.setDeploymentPlatform("AWS");
        ResponseEntity<ServiceEntity> createResponse = restTemplate.postForEntity("/api/services", serviceEntity, ServiceEntity.class);

        ServiceEntity updatedServiceEntity = createResponse.getBody();
        assertThat(updatedServiceEntity).isNotNull();
        updatedServiceEntity.setDeploymentPlatform("AWS - Updated");

        HttpEntity<ServiceEntity> requestEntity = new HttpEntity<>(updatedServiceEntity);
        ResponseEntity<ServiceEntity> updateResponse = restTemplate.exchange("/api/services/{id}", HttpMethod.PUT, requestEntity, ServiceEntity.class, updatedServiceEntity.getId());
        assertThat(updateResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(updateResponse.getBody().getDeploymentPlatform()).isEqualTo("AWS - Updated");
    }

    @Test
    public void testDeleteService_success() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("Delete GithubUploadTest ServiceEntity");
        serviceEntity.setServiceType(ServiceType.P3);
        serviceEntity.setDeploymentPlatform("AWS");
        ResponseEntity<ServiceEntity> createResponse = restTemplate.postForEntity("/api/services", serviceEntity, ServiceEntity.class);

        ServiceEntity createdServiceEntity = createResponse.getBody();
        assertThat(createdServiceEntity).isNotNull();

        restTemplate.delete("/api/services/{id}", createdServiceEntity.getId());

        ResponseEntity<ServiceEntity> response = restTemplate.getForEntity("/api/services/{id}", ServiceEntity.class, createdServiceEntity.getId());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testAddLibraryToService_success() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("ServiceEntity with LibraryEntity");
        serviceEntity.setServiceType(ServiceType.P1);
        serviceEntity.setDeploymentPlatform("AWS");
        ResponseEntity<ServiceEntity> serviceResponse = restTemplate.postForEntity("/api/services", serviceEntity, ServiceEntity.class);
        assertThat(serviceResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName("LibraryEntity for ServiceEntity");
        libraryEntity.setVersion("1.0");
        ResponseEntity<LibraryEntity> libraryResponse = restTemplate.postForEntity("/api/libraries", libraryEntity, LibraryEntity.class);
        assertThat(libraryResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        HttpEntity<LibraryEntity> requestEntity = new HttpEntity<>(libraryResponse.getBody());
        ResponseEntity<ServiceEntity> addLibraryResponse = restTemplate.exchange(
                "/api/services/{id}/libraries", HttpMethod.POST, requestEntity, ServiceEntity.class, serviceResponse.getBody().getId());
        assertThat(addLibraryResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(addLibraryResponse.getBody().getLibraries()).hasSize(1);
    }

    @Test
    public void testAddLibraryToService_serviceNotFound() {
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName("Orphan LibraryEntity");
        libraryEntity.setVersion("1.0");
        ResponseEntity<LibraryEntity> libraryResponse = restTemplate.postForEntity("/api/libraries", libraryEntity, LibraryEntity.class);
        assertThat(libraryResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        HttpEntity<LibraryEntity> requestEntity = new HttpEntity<>(libraryResponse.getBody());
        ResponseEntity<ServiceEntity> addLibraryResponse = restTemplate.exchange(
                "/api/services/{id}/libraries", HttpMethod.POST, requestEntity, ServiceEntity.class, 999L); // Non-existent service ID
        assertThat(addLibraryResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testAddLibraryToService_libraryNotFound() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("ServiceEntity without LibraryEntity");
        serviceEntity.setServiceType(ServiceType.P2);
        serviceEntity.setDeploymentPlatform("Azure");
        ResponseEntity<ServiceEntity> serviceResponse = restTemplate.postForEntity("/api/services", serviceEntity, ServiceEntity.class);
        assertThat(serviceResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        LibraryEntity nonExistentLibraryEntity = new LibraryEntity();
        nonExistentLibraryEntity.setId(999L); // Non-existent library ID

        HttpEntity<LibraryEntity> requestEntity = new HttpEntity<>(nonExistentLibraryEntity);
        ResponseEntity<ServiceEntity> addLibraryResponse = restTemplate.exchange(
                "/api/services/{id}/libraries", HttpMethod.POST, requestEntity, ServiceEntity.class, serviceResponse.getBody().getId());
        assertThat(addLibraryResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
