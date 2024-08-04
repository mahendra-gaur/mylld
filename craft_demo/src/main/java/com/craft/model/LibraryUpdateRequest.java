package com.craft.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LibraryUpdateRequest {
    @NotBlank(message = "Description is required")
    private String description;
}
