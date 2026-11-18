package com.jefferson.center.platform.andes.interfaces.rest.resources;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DeliveryOrderResource(
        Long id,
        String deliveryCode,
        String warehouseId,
        LocalDate deliveryWindowStartDate,
        LocalDate deliveryWindowEndDate,
        Integer packageLoadQuantity,
        String packageLoadUnit,
        Integer priorityLevel,
        String status,
        String deliveryNotes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
