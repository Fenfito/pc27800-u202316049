package com.jefferson.center.platform.andes.infrastructure.converters;

import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DeliveryCodePersistenceConverter implements AttributeConverter<DeliveryCode, String> {
    @Override
    public String convertToDatabaseColumn(DeliveryCode deliveryCode) {
        return deliveryCode != null ? deliveryCode.deliveryCode() : null;
    }

    @Override
    public DeliveryCode convertToEntityAttribute(String s) {
        return s != null ? new DeliveryCode(s) : null;
    }
}
