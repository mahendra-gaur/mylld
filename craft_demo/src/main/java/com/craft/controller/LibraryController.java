package com.craft.controller;

import com.craft.entity.LibraryEntity;
import com.craft.model.LibraryRequest;
import com.craft.model.LibraryUpdateRequest;
import com.craft.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/libraries")
@Validated
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<LibraryEntity> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryEntity> getLibraryById(@PathVariable Long id) {
        return libraryService.getLibraryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LibraryEntity> createLibrary(@Valid @RequestBody LibraryRequest libraryRequest) {
        LibraryEntity libraryEntity = libraryService.createLibrary(libraryRequest);
        return new ResponseEntity<>(libraryEntity, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LibraryEntity> updateLibrary(@PathVariable Long id, @Valid @RequestBody LibraryUpdateRequest update) {
        return ResponseEntity.ok(libraryService.updateLibrary(id, update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }
}
