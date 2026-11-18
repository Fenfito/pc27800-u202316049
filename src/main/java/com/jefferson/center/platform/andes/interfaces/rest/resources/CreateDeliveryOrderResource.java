package com.jefferson.center.platform.andes.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CreateDeliveryOrderResource(
        @NotBlank String deliveryCode,
        @NotBlank String warehouseId,
        @NotNull LocalDate deliveryWindowStartDate,
        @NotNull LocalDate deliveryWindowEndDate,
        @NotNull @Positive Integer packageLoadQuantity,
        @NotBlank String packageLoadUnit,
        @NotNull @Min(1) @Max(5) Integer priorityLevel,
        String deliveryStatus,
        String deliveryNotes
) {
}
