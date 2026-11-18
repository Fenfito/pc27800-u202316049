package com.jefferson.center.platform.andes.infrastructure.converters;

import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DeliveryStatusPersistenceConverter implements AttributeConverter<DeliveryStatus, String> {

    @Override
    public String convertToDatabaseColumn(DeliveryStatus attribute) {
        return attribute != null ? attribute.name() : null;
    }

    @Override
    public DeliveryStatus convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        try {
            return DeliveryStatus.valueOf(s);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Unknown delivery status: " + s, exception);
        }
    }
}
