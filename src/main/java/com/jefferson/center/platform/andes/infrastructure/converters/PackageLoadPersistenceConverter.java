package com.jefferson.center.platform.andes.infrastructure.converters;

import com.jefferson.center.platform.andes.domain.model.valueobjects.PackageLoad;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PackageLoadPersistenceConverter implements AttributeConverter<PackageLoad, String> {
    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(PackageLoad packageLoad) {
        return packageLoad != null
                ? packageLoad.quantity() + SEPARATOR + packageLoad.unit()
                : null;
    }

    @Override
    public PackageLoad convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        try {
            String[] parts = value.split(SEPARATOR, 2);
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid package load value");
            }
            return new PackageLoad(
                    Integer.valueOf(parts[0].trim()),
                    parts[1].trim()
            );
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid package load value: " + value, exception);
        }
    }
}
