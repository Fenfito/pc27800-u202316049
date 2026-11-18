package com.jefferson.center.platform.andes.domain.model.valueobjects;

public record PackageLoad(Integer quantity, String unit) {
    public PackageLoad {
        if (quantity == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Unit cannot be null or blank");
        }
    }

    public PackageLoad increaseBy(Integer additionalQuantity) {
        if (additionalQuantity == null) {
            throw new IllegalArgumentException("Additional quantity cannot be null");
        }
        if (additionalQuantity <= 0) {
            throw new IllegalArgumentException("Additional quantity must be greater than zero");
        }
        if (additionalQuantity > Integer.MAX_VALUE - quantity) {
            throw new IllegalArgumentException("The resulting quantity exceeds Integer.MAX_VALUE");
        }
        return new PackageLoad(quantity + additionalQuantity, unit);
    }
}
