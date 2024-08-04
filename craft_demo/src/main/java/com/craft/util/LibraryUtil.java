package com.craft.util;

import com.craft.entity.LibraryEntity;
import com.craft.model.Library;

public class LibraryUtil {
    public static void updateProperties(LibraryEntity libraryEntityDetails, LibraryEntity libraryEntity) {
        libraryEntity.setName(libraryEntityDetails.getName());
        libraryEntity.setDescription(libraryEntityDetails.getDescription());
        libraryEntity.setCodeRepository(libraryEntityDetails.getCodeRepository());
        libraryEntity.setLineOfBusiness(libraryEntityDetails.getLineOfBusiness());
        libraryEntity.setVersion(libraryEntityDetails.getVersion());
    }

    public static LibraryEntity getLibraryEntity(Library library) {
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setName(library.getName());
        libraryEntity.setDescription(library.getDescription());
        libraryEntity.setLineOfBusiness(library.getLineOfBusiness());

        return libraryEntity;
    }
}
