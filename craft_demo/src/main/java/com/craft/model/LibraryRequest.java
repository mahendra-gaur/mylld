package com.craft.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LibraryRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "LineOfBusiness is required")
    private String lineOfBusiness;

    private String description;
}
