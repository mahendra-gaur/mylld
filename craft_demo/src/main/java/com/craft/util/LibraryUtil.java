package com.craft.util;

import com.craft.entity.LibraryEntity;
import com.craft.model.LibraryRequest;
import com.craft.model.LibraryUpdateRequest;

public class LibraryUtil {
    public static void updateProperties(LibraryEntity libraryEntityDetails, LibraryUpdateRequest library) {
        libraryEntityDetails.setDescription(library.getDescription());
    }

    public static LibraryEntity getLibraryEntity(LibraryRequest libraryRequest) {
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName(libraryRequest.getName());
        libraryEntity.setDescription(libraryRequest.getDescription());
        libraryEntity.setLineOfBusiness(libraryRequest.getLineOfBusiness());

        return libraryEntity;
    }
}
