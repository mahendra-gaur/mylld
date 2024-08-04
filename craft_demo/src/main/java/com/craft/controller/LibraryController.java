package com.craft.controller;

import com.craft.entity.LibraryEntity;
import com.craft.model.Library;
import com.craft.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraries")
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
    public LibraryEntity createLibrary(@RequestBody Library library) {
        return libraryService.createLibrary(library);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryEntity> updateLibrary(@PathVariable Long id, @RequestBody LibraryEntity libraryEntityDetails) {
        return ResponseEntity.ok(libraryService.updateLibrary(id, libraryEntityDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }
}
