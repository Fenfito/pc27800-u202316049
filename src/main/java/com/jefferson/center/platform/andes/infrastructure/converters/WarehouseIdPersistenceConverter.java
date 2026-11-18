package com.jefferson.center.platform.andes.infrastructure.converters;

import com.jefferson.center.platform.andes.domain.model.valueobjects.WarehouseId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class WarehouseIdPersistenceConverter implements AttributeConverter<WarehouseId, String> {
    @Override
    public String convertToDatabaseColumn(WarehouseId warehouseId) {
        return warehouseId != null ? warehouseId.warehouseId() : null;
    }

    @Override
    public WarehouseId convertToEntityAttribute(String value) {
        return value != null ? new WarehouseId(value) : null;
    }
}
