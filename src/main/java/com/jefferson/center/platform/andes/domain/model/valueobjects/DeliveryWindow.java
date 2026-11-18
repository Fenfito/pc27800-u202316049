package com.jefferson.center.platform.andes.domain.model.valueobjects;

import java.time.LocalDate;

public record DeliveryWindow(LocalDate startDate, LocalDate endDate) {
    public DeliveryWindow {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null");
        }
        if (endDate == null) {
            throw new IllegalArgumentException("End date cannot be null");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
    }

    public boolean includes(LocalDate checkDate) {
        if (checkDate == null) {
            throw new IllegalArgumentException("Check date cannot be null");
        }
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}
