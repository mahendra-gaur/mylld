package com.craft.service;
import com.craft.command.library.LibraryCommandExecutor;
import com.craft.entity.LibraryEntity;
import com.craft.exception.ResourceNotFoundException;
import com.craft.model.LibraryRequest;
import com.craft.model.LibraryUpdateRequest;
import com.craft.repository.LibraryRepository;
import com.craft.util.LibraryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<LibraryEntity> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Optional<LibraryEntity> getLibraryById(Long id) {
        return libraryRepository.findById(id);
    }

    public LibraryEntity createLibrary(LibraryRequest libraryRequest) {
        LibraryEntity libraryEntity = LibraryUtil.getLibraryEntity(libraryRequest);
        LibraryCommandExecutor executor = new LibraryCommandExecutor(libraryEntity);
        try {
            executor.execute(); // Execute lib creation
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e); // Result in HTTP 500 Internal server error
        }
        return libraryRepository.save(libraryEntity); // Save to DB
    }

    //TODO: Possible future enhancement: based upon updated request property decide weather we should re-build lib again and generate new version or not.
    public LibraryEntity updateLibrary(Long id, LibraryUpdateRequest library) {
        LibraryEntity libraryEntity = libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LibraryEntity not found"));
        LibraryUtil.updateProperties(libraryEntity, library);
        return libraryRepository.save(libraryEntity);
    }

    public void deleteLibrary(Long id) {
        LibraryEntity libraryEntity = libraryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LibraryEntity not found"));
        libraryRepository.delete(libraryEntity);
    }
}
