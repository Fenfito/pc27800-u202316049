package com.jefferson.center.platform.andes.domain.model.valueobjects;

public record DeliveryCode(String deliveryCode) {
    public DeliveryCode {
        if (deliveryCode == null || deliveryCode.isBlank()) {
            throw new IllegalArgumentException("Delivery code cannot be null or blank");
        }
    }

    public String value() {
        return deliveryCode;
    }
}
