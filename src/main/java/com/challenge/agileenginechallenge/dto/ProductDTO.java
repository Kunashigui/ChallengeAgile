package com.challenge.agileenginechallenge.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private UUID id;

    @NotEmpty(message = "Product name is required")
    private String name;

    @Nullable
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Integer stock;
}
