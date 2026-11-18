package com.jefferson.center.platform.andes.application.commands;

import java.time.LocalDate;

public record CreateDeliveryOrderCommand(
        String deliveryCode,
        String warehouseId,
        LocalDate deliveryWindowStartDate,
        LocalDate deliveryWindowEndDate,
        Integer packageLoadQuantity,
        String packageLoadUnit,
        Integer priorityLevel,
        String deliveryStatus,
        String deliveryNotes
) {
}
