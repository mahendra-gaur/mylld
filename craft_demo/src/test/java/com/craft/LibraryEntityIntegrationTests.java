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
public class LibraryEntityIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateLibrary_success() {
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName("Test LibraryEntity");
        libraryEntity.setVersion("1.0");

        ResponseEntity<LibraryEntity> response = restTemplate.postForEntity("/api/libraries", libraryEntity, LibraryEntity.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test LibraryEntity");
    }

    @Test
    public void testCreateLibrary_duplicateName() {
        LibraryEntity libraryEntity1 = new LibraryEntity();
        libraryEntity1.setName("Duplicate LibraryEntity");
        libraryEntity1.setVersion("1.0");
        restTemplate.postForEntity("/api/libraries", libraryEntity1, LibraryEntity.class);

        LibraryEntity libraryEntity2 = new LibraryEntity();
        libraryEntity2.setName("Duplicate LibraryEntity");
        libraryEntity2.setVersion("2.0");

        ResponseEntity<String> response = restTemplate.postForEntity("/api/libraries", libraryEntity2, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
        assertThat(response.getBody()).contains("LibraryEntity name must be unique");
    }

    @Test
    public void testGetLibraryById_notFound() {
        ResponseEntity<LibraryEntity> response = restTemplate.getForEntity("/api/libraries/{id}", LibraryEntity.class, 999L);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testUpdateLibrary_success() {
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName("Update Test LibraryEntity");
        libraryEntity.setVersion("1.0");
        ResponseEntity<LibraryEntity> createResponse = restTemplate.postForEntity("/api/libraries", libraryEntity, LibraryEntity.class);

        LibraryEntity updatedLibraryEntity = createResponse.getBody();
        assertThat(updatedLibraryEntity).isNotNull();
        updatedLibraryEntity.setVersion("2.0");

        HttpEntity<LibraryEntity> requestEntity = new HttpEntity<>(updatedLibraryEntity);
        ResponseEntity<LibraryEntity> updateResponse = restTemplate.exchange("/api/libraries/{id}", HttpMethod.PUT, requestEntity, LibraryEntity.class, updatedLibraryEntity.getId());
        assertThat(updateResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(updateResponse.getBody().getVersion()).isEqualTo("2.0");
    }

    @Test
    public void testDeleteLibrary_success() {
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName("Delete Test LibraryEntity");
        libraryEntity.setVersion("1.0");
        ResponseEntity<LibraryEntity> createResponse = restTemplate.postForEntity("/api/libraries", libraryEntity, LibraryEntity.class);

        LibraryEntity createdLibraryEntity = createResponse.getBody();
        assertThat(createdLibraryEntity).isNotNull();

        restTemplate.delete("/api/libraries/{id}", createdLibraryEntity.getId());

        ResponseEntity<LibraryEntity> response = restTemplate.getForEntity("/api/libraries/{id}", LibraryEntity.class, createdLibraryEntity.getId());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testAddLibraryToService_success() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("Test ServiceEntity");
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
}
