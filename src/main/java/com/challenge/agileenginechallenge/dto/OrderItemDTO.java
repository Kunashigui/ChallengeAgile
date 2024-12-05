package com.challenge.agileenginechallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

    @NotNull
    private UUID id;

    @NotNull
    private UUID orderId;

    @NotNull
    private UUID productId;

    @NotNull
    private Integer quantity;
}
