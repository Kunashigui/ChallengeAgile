package com.challenge.agileenginechallenge.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private UUID id;

    @NotEmpty(message = "Customer name is required")
    private String customerName;

    @NotEmpty(message = "Customer email is required")
    private String customerEmail;

    @NotNull
    private LocalDateTime orderDate;

    private List<OrderItemDTO> items;
}
