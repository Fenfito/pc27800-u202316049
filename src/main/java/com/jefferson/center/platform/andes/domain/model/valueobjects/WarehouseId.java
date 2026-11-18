package com.jefferson.center.platform.andes.domain.model.valueobjects;

public record WarehouseId(String warehouseId) {
    public WarehouseId {
        if (warehouseId == null || warehouseId.isBlank()) {
            throw new IllegalArgumentException("Warehouse ID cannot be null or blank");
        }
    }
}
